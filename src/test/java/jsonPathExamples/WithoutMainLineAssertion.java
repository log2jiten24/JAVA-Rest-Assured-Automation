package jsonPathExamples;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class WithoutMainLineAssertion {

	public static void main(String[] args) {
		
	String jsonResponse = "" ;
		
	jsonResponse = RestAssured
		           .given()
		                   .baseUri("https://restful-booker.herokuapp.com/auth")
		                   .log()
		                   .all()
		                   .body("{\r\n" + 
		                   		"    \"username\" : \"admin\",\r\n" + 
		                   		"    \"password\" : \"password123\"\r\n" + 
		                   		"}")
		                   .contentType(ContentType.JSON)
		            .when()
		                   .post()
		            .then()
		                   .log()
		                   .all()
		                   .extract()
		                   .asString() ;
	
	  //Get the JsonPath Response as String 	                    
	  JsonPath jsonpath = new JsonPath(jsonResponse);
	  //Assertion - to assert whether the token received is not null 
	  Assert.assertNotNull(jsonpath.get("token"));    
	  System.out.println ("Token ID - " + " " + jsonpath.getString("token"));

	}

}
