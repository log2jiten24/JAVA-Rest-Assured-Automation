package jsonPathExamples;

import java.io.File;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JsonSchemaValidator {

	public static void main(String[] args) {
		
		

		 RestAssured
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
		                   .statusCode(200)
		                  // .body(io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateBookingJSONSchema.json"));
		                  //Alternative we can do in another way 
		                   .body(io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema(new File("F:\\Cucumber6Series\\RestAssuredProject\\resources"
		                   		+ "\\CreateBookingJSONSchema.json")));

	}

}
