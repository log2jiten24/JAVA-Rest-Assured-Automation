package restAPIExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssured_BDDFormat {

	public static void main(String[] args) {
		
		//Given - Set up Request 
		//When - Build the Request 
		//Then - Validate the Response 
		
		RestAssured.
		            given()
		            		.log()
		            		    .all()
		            		          .baseUri("https://restful-booker.herokuapp.com/")
		            		          .basePath("booking")
		            		          .body("{\r\n" + 
		            		          		"    \"firstname\" : \"Jiten007\",\r\n" + 
		            		          		"    \"lastname\" : \"Brown\",\r\n" + 
		            		          		"    \"totalprice\" : 111,\r\n" + 
		            		          		"    \"depositpaid\" : true,\r\n" + 
		            		          		"    \"bookingdates\" : {\r\n" + 
		            		          		"        \"checkin\" : \"2018-01-01\",\r\n" + 
		            		          		"        \"checkout\" : \"2019-01-01\"\r\n" + 
		            		          		"    },\r\n" + 
		            		          		"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
		            		          		"}")
		            		            .contentType(ContentType.JSON)
		            .when()
		            //Hit the request 
		                    .post()
		            .then()
		            //validate the response code 
		                    .statusCode(200)
		                    .log()
		                    .all();
		
		
	}

}
