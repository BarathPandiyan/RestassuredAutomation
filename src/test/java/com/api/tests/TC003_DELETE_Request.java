package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_DELETE_Request {
	
	final String BASE_URI = "https://reqres.in/api/users";
	RequestSpecification httpRequest;
	
	@BeforeClass
	public void setUp() {
		
	}
	
	@Test
	void reqResDelete_Testing() {
		 
		  RestAssured.baseURI = BASE_URI; 		//Specify base URI
		  httpRequest = RestAssured.given();		//Request object
		  
		  Response response = httpRequest.request(Method.DELETE, "/2");
		  System.out.println("Response code is : " + response.getStatusCode() );
		  Assert.assertEquals(response.getStatusCode(), 204);
		  
	}
}
