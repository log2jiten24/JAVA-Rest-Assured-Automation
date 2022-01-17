package jsonPathExamples;

import java.io.File;

import org.hamcrest.MatcherAssert;

public class VerifyJsonSchemaValidator {

	public static void main(String[] args) {
	
		
		String json_Resp = "{\r\n" + 
				"    \"bookingid\": 1,\r\n" + 
				"    \"booking\": {\r\n" + 
				"        \"firstname\": \"Jim\",\r\n" + 
				"        \"lastname\": \"Brown\",\r\n" + 
				"        \"totalprice\": 111,\r\n" + 
				"        \"depositpaid\": true,\r\n" + 
				"        \"bookingdates\": {\r\n" + 
				"            \"checkin\": \"2018-01-01\",\r\n" + 
				"            \"checkout\": \"2019-01-01\"\r\n" + 
				"        },\r\n" + 
				"        \"additionalneeds\": \"Breakfast\"\r\n" + 
				"    }\r\n" + 
				"}" ;
		
		MatcherAssert.assertThat(json_Resp	, io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema(new File("F:\\Cucumber6Series\\RestAssuredProject\\resources"
           		+ "\\CreateBookingJSONSchema.json")));

	}

}
