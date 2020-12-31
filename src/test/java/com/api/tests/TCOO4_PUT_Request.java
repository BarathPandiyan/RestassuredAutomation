package com.api.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.test.pojos.Jobs;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TCOO4_PUT_Request {
	
	final String BASE_URI = "https://reqres.in/api/users";
	Jobs testJob;
	Gson gson = new Gson();
	
	@BeforeClass
	public void setUp() {
		testJob = new Jobs( "morpheus", "zion resident" );
		
	}
	
	@Test
	void reqResPut_Testing() {
		  
		RestAssured.baseURI = BASE_URI;								//Specify base URI
		RequestSpecification httpRequest = RestAssured.given();		//Request object

		httpRequest.header("Content-Type","application/json");
		httpRequest.body(testJob.getJSON());
		  
		Response response = httpRequest.request(Method.PUT,"/2");
		Jobs expectedJob = gson.fromJson(response.getBody().asString(), Jobs.class);
		  
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(expectedJob.getName(), "morpheus");
		Assert.assertEquals(expectedJob.getJob(), "zion resident");
		  
	}
}
