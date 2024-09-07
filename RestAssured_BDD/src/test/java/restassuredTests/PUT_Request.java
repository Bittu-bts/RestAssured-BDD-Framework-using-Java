package restassuredTests;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PUT_Request {
	
	@Test
	public void testPut() {
		
		
		JSONObject request = new JSONObject();
		
		request.put("id", 8931);
		request.put("name", "xyz");
		request.put("email", "zbc@gmail.com");
		request.put("gender", "Female");
		request.put("status", "Active");
		
		System.out.println(request.toJSONString());
		
		RestAssured.baseURI="https://gorest.co.in";
    	//RestAssured.basePath="/public/v2/users/6797763"; 
    	
    	RequestSpecification requestSpec = RestAssured.given();
	    String Authtoken = "Bearer 21db41271537a4de218c2236072efc6e74897f3daf27506ead379fc21598e756";
        requestSpec.header("Authorization", Authtoken)
        .header("Content-Type", "application/json")
        .contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .body(request.toJSONString())
        
        .when()
           .put("/public/v2/users/7327667")
           
         .then()
           .statusCode(200)
           .log().body()
           .assertThat().body("name", equalTo("xyz"));
	}


}
