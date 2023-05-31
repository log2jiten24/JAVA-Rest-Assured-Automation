package jsonSchemaValidation;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {

	public static void main(String[] args) {
		
		
		 RestAssured
         .given()
                 .baseUri("https://restful-booker.herokuapp.com/auth")
                 .log()
                 .all()
                 .body("{\r\n" + 
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
                 		"}")
                 .contentType(ContentType.JSON)
          .when()
                 .post()
          .then()
                .log()
                 .all()
                 .statusCode(200)
                 //.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateBookingJSONSchema.json"));
                .body(JsonSchemaValidator.
          matchesJsonSchema(new File ("F:\\Cucumber6Series\\RestAssuredProject\\resources\\CreateBookingJSONSchema.json")));

	}

}
