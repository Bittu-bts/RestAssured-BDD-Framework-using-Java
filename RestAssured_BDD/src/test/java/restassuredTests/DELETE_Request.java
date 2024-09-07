package restassuredTests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class DELETE_Request {
	
	@Test
	public void testDelete() {
		
		RestAssured.baseURI="https://gorest.co.in";
    	//RestAssured.basePath="/public/v2/users/6797763"; 
    	
    	RequestSpecification requestSpec = RestAssured.given();
	    String Authtoken = "Bearer 21db41271537a4de218c2236072efc6e74897f3daf27506ead379fc21598e756";
        requestSpec.header("Authorization", Authtoken)
        
        .when()
           .delete("/public/v2/users/6798093")
           
         .then()
           .statusCode(204)
           .log().all();
	}


}
