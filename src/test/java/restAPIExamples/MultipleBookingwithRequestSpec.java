package restAPIExamples;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class MultipleBookingwithRequestSpec {
	
	//store all the useful methods inside it 
	
	RequestSpecification requestSpec;
	
	@BeforeClass
	public void setUpRequestSpec() {
		
		requestSpec = RestAssured.given();
		
		  requestSpec
		             .log().all()
		             .baseUri("https://restful-booker.herokuapp.com")
		             .basePath("/booking")
		             .contentType(ContentType.JSON);	
	}
	
	
	

	@Test
	public void createBooking() {

RestAssured
		.given()
		//specification method is reusable method to pass all the common methods 
		        .spec(requestSpec)
		        .body("{\r\n" + "    \"firstname\" : \"Jiten007\",\r\n" + "    \"lastname\" : \"Brewown001\",\r\n"
						+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
				// Hit the request
		.when()
				.post()
		.then()
				// validate the response code
				.statusCode(200);

	}

	@Test
	public void updateBooking() {

RestAssured
		.given()
		        //passing the common methods from the specification 
		        .spec(requestSpec)
				// passing the parameters
				.basePath("{basePath}/{bookingId}")
				.pathParam("basePath", "booking")
				.pathParam("bookingId", 10)
				// pass the headers value inside the request
				.header("Content-type", "application/json")
				.headers("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
				.body("{\r\n" + "    \"firstname\" : \"JamesMilan\",\r\n" + "    \"lastname\" : \"Brown\",\r\n"
						+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
		.when()
				// hit the request
				.put()
				// Validate the response
		.then()
				.log().all().assertThat().statusCode(200);

	}

}
