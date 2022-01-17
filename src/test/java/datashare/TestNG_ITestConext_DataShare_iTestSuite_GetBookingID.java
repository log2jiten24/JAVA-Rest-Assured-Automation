package datashare;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestNG_ITestConext_DataShare_iTestSuite_GetBookingID {
	
	@Test
	public void retrieveBookingID (ITestContext context) {
		
		Response response = RestAssured.given().log().all().contentType(ContentType.JSON)
				
		// Hit the Request and get the Response and with the help of context Interface get the booking ID from the getAttribute Method 
				
		.get("https://restful-booker.herokuapp.com/booking/" + context.getSuite().getAttribute("bookingID1"))
		// validate the response
		.then().log().all().statusCode(200)
		// extract the response and get the Integer Booking Id from the Response
		.extract().response();
	
        // Use JSON Path to retrieve the first name payload values
        System.out.println("FirstName is :" + response.jsonPath().getString("firstname"));
        
        System.out.println("Json Response :" + response.asPrettyString());
       // Convert JAVA Response to the Map and retrieve each Key and values
       java.util.Map<String, Object> all_Map = response.as(java.util.Map.class);
      // Retrieve all the Key values
       System.out.println(all_Map.keySet());
       // Retrieve all the values
       System.out.println(all_Map.values());
		
		
		
	}

}
