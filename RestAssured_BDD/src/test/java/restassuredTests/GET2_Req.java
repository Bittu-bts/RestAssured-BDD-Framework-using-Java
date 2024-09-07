package restassuredTests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class GET2_Req {
	
	@Test
	public void getNorway() {
		
	        // Set the base URI for the API
	        RestAssured.baseURI = "https://restcountries.com/v3.1/name/norway";

	        // Create the request specification
	        RequestSpecification requestSpec = given()
	            .header("Content-Type", "application/json");

	        // Make the GET request and store the response
	        Response response = requestSpec
	            .when()
	            .get("/v3.1/name/norway")
	            .then()
	            .extract()
	            .response();

	        // Check the status code
	        int statusCode = response.getStatusCode();
	        
	        if (statusCode == 200) {
	            // Extract the capital from the response
	            String capital = response.jsonPath().getString("[0].capital");
	            
	            // Validate that the capital is Oslo
	            if ("Oslo".equals(capital)) {
	                System.out.println("The capital of Norway is Oslo.");
	            } else {
	                System.out.println("The capital of Norway is not Oslo, it is: " + capital);
	            }
	            
	            // Print the details of Norway
	            System.out.println("Details of Norway:");
	            response.prettyPrint();
	        } else {
	            // Print the status code and message if not found or other errors
	            System.out.println("Unexpected status code: " + statusCode);
	            String errorMessage = response.jsonPath().getString("message");
	            System.out.println("Error message: " + errorMessage);
	        }
	    }
	}
	
