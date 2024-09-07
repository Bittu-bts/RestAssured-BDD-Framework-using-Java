package restassuredTests;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET1_Req {
	
	@Test
	public void get() {	
			
		RestAssured.baseURI="https://restcountries.com";
      
		RequestSpecification requestSpec = RestAssured.given()
		.header("Content-Type", "application/json");
		
	    Response response =	requestSpec
		.when()
		   .get("/v3.1/name/india")
		.then()
           .assertThat().body("[0].name.official", equalTo("Republic of India"))
		   .extract().response();
	    
	    //Check the status code and print the response accordingly
	    int statusCode = response.getStatusCode();
	    if(statusCode == 200) {
	    	
	    	//extracting official name
	    	String officialName = response.jsonPath().getString("[0].name.official");
	    	System.out.print("Official name of India: " + officialName);
	    } else if (statusCode == 404) {
	    	
	    	//print the error message
	    	String errorMessage = response.jsonPath().getString("message");
	    	System.out.println("404: " + errorMessage);
	    } else {
	    	//Handle other status code
	    	System.out.println("unexpected error: " + statusCode);
	    }
	    	     
	}  

}
