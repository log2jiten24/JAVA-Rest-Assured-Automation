package restAPIExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Create_booking_Post_Call {

	public static void main(String[] args) {

		// Follow three steps to hit an API using Rest Assured Library
		// Build the request
		RequestSpecification requestSpec = RestAssured.given();
		//add log method to print the request inside the console 
		requestSpec = requestSpec.log().all();
		
		// construct the base URL and base Path
		requestSpec.baseUri("https://restful-booker.herokuapp.com/");
		// base Path can change depending upon the different resources
		requestSpec.basePath("booking");

		// pass the JSON Body to form the request
		requestSpec.body("{\r\n" + 
				"    \"firstname\" : \"Jimmmyyy\",\r\n" + 
				"    \"lastname\" : \"Brrrrown\",\r\n" + 
				"    \"totalprice\" : 111,\r\n" + 
				"    \"depositpaid\" : true,\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \"2018-01-01\",\r\n" + 
				"        \"checkout\" : \"2019-01-01\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
				"}");
		
		// pass the request in the form of JSON
		// requestSpec.contentType("application/json");
		// to make it more generic
		requestSpec.contentType(ContentType.JSON);

		// Hit Request and get the Response-- it will be stored inside the Response Interface 
		 Response response  = requestSpec.post();
		
		// Validate the Response-- after hitting the request, we got response and that response can be used to 
		//convert the response into validate response by using the then method 
		//ValidateResponse is an Interface which we can use to store the response 
		ValidatableResponse validateresponse  =  response.then().log().all();
		//validate the status code 
		validateresponse.statusCode(200); 
		//add log method to print the response inside the console 
		//validateresponse = validateresponse.log().all();

	}

}
