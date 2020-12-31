package com.api.tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.test.pojos.Jobs;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC002_POST_Request {
	
	final String BASE_URI = "https://reqres.in/api"; //Specify base URI
	Jobs testJobs;
	Gson gson;
	RequestSpecification httpRequest;
	
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = BASE_URI;
		gson = new Gson();
		httpRequest = RestAssured.given(); 				//Request object creation
		testJobs = new Jobs("New Name", "Finding");		//Request paylaod sending along with post request
	}
	
	 @Test
	 void ReqResPOST_Testing()
	 {
		 httpRequest.header("Content-Type","application/json");
		 httpRequest.body(testJobs.getJSON()); 									// attach above data to the request
		  
		 Response response = httpRequest.request(Method.POST,"/users/2");			//Response object creation and assigning
		 String responseBody = response.getBody().asString();
		  
		 int statusCode = response.getStatusCode(); 								//status code validation
		  
		 Jobs expectedJobs = gson.fromJson(responseBody, Jobs.class);
		  
		 Assert.assertEquals(expectedJobs.getName(), "New Name", "Name did not match");
		 Assert.assertEquals(expectedJobs.getJob(), "Finding", "Job did not match");
		  
		 Assert.assertEquals(statusCode, 201);
	 }
	 
	 @AfterClass
	 public void tearDown() {
		 
	 }
	
}
