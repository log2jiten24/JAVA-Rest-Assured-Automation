package restAPIExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class MethodChaining_Post {

	public static void main(String[] args) {
	
		//do the method chaining - where the multiple methods can be called in a single call -- here we are trying to 
		//call different methods for the same RequestSpecification same return  type 
		
		//Setup Request 
		RestAssured
		.given()
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking")
		.body("{\r\n" + 
				"    \"firstname\" : \"Jimmmyyy\",\r\n" + 
				"    \"lastname\" : \"BrownAajjaa\",\r\n" + 
				"    \"totalprice\" : 111,\r\n" + 
				"    \"depositpaid\" : true,\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \"2018-01-01\",\r\n" + 
				"        \"checkout\" : \"2019-01-01\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
				"}")
		.contentType(ContentType.JSON)
		//Hit the Request and get the Response 
		.post()
		//validate the response 
		.then()
		.log()
		.all()
		.statusCode(200);
		
		
		

	}

}
