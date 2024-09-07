package restassuredTests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class GET_Request {
	
	@Test
	public void getUsers() {		
		
		RestAssured.baseURI="https://gorest.co.in";
	
		RequestSpecification requestSpec = RestAssured.given();
        String Authtoken = "Bearer 21db41271537a4de218c2236072efc6e74897f3daf27506ead379fc21598e756";
        requestSpec.header("Authorization", Authtoken)
    	.when()
		   .get("/public/v2/7327667")
		.then()
		   .statusCode(200)
		   // .statusLine("HTTP/1.1 404 Not Found")
		  // .assertThat().body("name", equalTo("Mani Sinha"))
		   .log().all();
		    //.header("Content-Type", "application/json");
		     
	}  
//	@Test
//	public void test() {
//		RestAssured.baseURI="https://gorest.co.in";
//		RequestSpecification requestSpec = RestAssured.given();
//	    String Authtoken = "Bearer 21db41271537a4de218c2236072efc6e74897f3daf27506ead379fc21598e756";
//        requestSpec.header("Authorization", Authtoken);
//        
//		Response response = RestAssured.get("/public/v2/users/6799737");
//		
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getBody().asString());
//		System.out.println(response.getHeader("content-type"));
//		
//		int statusCode = response.getStatusCode();
//		Assert.assertEquals(statusCode, 200);
//		
//		//Assert.assertEquals("Arum", "Arum");
//	}
//	

}
