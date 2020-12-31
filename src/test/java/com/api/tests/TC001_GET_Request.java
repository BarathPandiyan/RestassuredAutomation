package com.api.tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.gson.Gson;
import com.test.pojos.Data;
import com.test.pojos.Link;
import com.test.pojos.Users;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	String baseUri = "https://reqres.in/api"; 		//Specify base URI
	
	Data dataObj = new Data(2, "janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg");// Converting POJO to JSON 
	Link linkObj = new Link("https://reqres.in/#support-heading", "To keep ReqRes free, contributions towards server costs are appreciated!");
	Users testUser = new Users(dataObj, linkObj);
	 
	@BeforeClass
	void setUp() {
		
	}
	
	 @Test
	 void ReqResGET_Testing()
	 {
//		 RestAssured.baseURI = "https://reqres.in/api/users?page=2"; 
		 RestAssured.baseURI = baseUri;
		 RequestSpecification httpRequest = RestAssured.given();					//Request object
		 Response response = httpRequest.request(Method.GET, "/users/2"); 		//Response object	
		 String responseBody = response.getBody().asString(); 					//getting body of response as a JSON string
	  
		 int statusCode = response.getStatusCode(); 								//status code validation
		 Assert.assertEquals(statusCode, 200);
		 
		 Gson gson = new Gson();													//converting user class object to json
		 String expectedResponse = gson.toJson(testUser);
		 Assert.assertEquals(responseBody, expectedResponse);
		 
//		 Converting JSON string to a Users Class Object
//		 Users userObject = gson.fromJson(responseBody, Users.class); 
//		 System.out.println("Converted JSON string java object details: " + userObject.toString());
			  
	 }
	 
	 @AfterClass
	 void tearDown() {
		 
	 }
	
}
