package datashare;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestNG_ITestConext_DataShare_iTestSuite {
	
	@Test
	public void createBooking(ITestContext context) {
		
		// Setup Request
				int id = RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/").basePath("booking")
						.body("{\r\n" + "    \"firstname\" : \"Jimmmyyy\",\r\n" + "    \"lastname\" : \"BrownAajjaa\",\r\n"
								+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
								+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
								+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
								+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
						.contentType(ContentType.JSON)
						// Hit the Request and get the Response
						.post()
						// validate the response
						.then().log().all().statusCode(200)
						// extract the response and get the Integer Booking Id from the Response
						.extract().jsonPath().getInt("bookingid");
				
		//using the method of ITestConext Interface use method as setAttribue - to store the value as key and pair
				//use getSuite method - if we we are planning to use as Different Suite Level Runs 
				context.getSuite().setAttribute("bookingID1", id);			
				
	}

}
