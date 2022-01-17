package restAPIExamples;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class MultipleBookingwithRequestSpec {
	
	//store all the useful methods inside it 
	
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setUpRequestSpec() {
		
		//add the request Specification which is common 
		
		requestSpec = RestAssured.given();
		
		  requestSpec
		             .log().all()
		             .baseUri("https://restful-booker.herokuapp.com")
		             .basePath("/booking")
		             .contentType(ContentType.JSON);	
		  
		  //add the Response Specification code which is common 
		 
		  responseSpec = RestAssured.expect();
		  responseSpec
		              .statusCode(200)
		              .contentType(ContentType.JSON)
		              .time(Matchers.lessThan(5000L));
				         
	}
	
	
	

	@Test
	public void createBooking() {
		
	//Create object of ResponseSpecification and pass it under the spec method-expect method will return ResponseSpecification 
	ResponseSpecification responseSpecification	 = RestAssured.expect();
	responseSpecification.statusCode(200);
	responseSpecification.contentType(ContentType.JSON);
	responseSpecification.time(Matchers.lessThan(5000L));

RestAssured
		.given()
		//specification method is reusable method to pass all the common methods 
		        .spec(requestSpec)
		        .body("{\r\n" + "    \"firstname\" : \"Jiten007\",\r\n" + "    \"lastname\" : \"Brewown001\",\r\n"
						+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
		        .contentType(ContentType.JSON)
				// Hit the request
		.when()
				.post()
		.then()
		        .log()
		        .all()
				// validate the response code
				//.statusCode(200)
                //validate the response is in JSON format
                //.contentType(ContentType.JSON)
                //verify the time out in the response is less than 5 seconds -which accepts seconds in Long type  
                //.time(Matchers.lessThan(5000L))
                //pass all the responseSpcification method under the spec method
				.spec(responseSpecification);
 
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
	
	
	@Test
	public void createBooking_02() {
		
	//use the common method from the Response Specification 

RestAssured
		.given()
		//specification method is reusable method to pass all the common methods 
		        .spec(requestSpec)
		        .body("{\r\n" + "    \"firstname\" : \"Jiten001000\",\r\n" + "    \"lastname\" : \"Brewown02222201\",\r\n"
						+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
		        .contentType(ContentType.JSON)
				// Hit the request
		.when()
				.post()
		.then()
		        .log()
		        .all()
				//pass all the responseSpcification method under the spec method
				.spec(responseSpec);
 
	}


}
