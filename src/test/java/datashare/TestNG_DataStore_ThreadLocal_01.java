package datashare;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestNG_DataStore_ThreadLocal_01 {
	

		// create global variables
		// private int bookingID ;

		@Test(priority = 1)
		public void createBooking() {

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

			// store the Booking Id inside the Map
			ThreadLocalDataStroeAsMap.setValue("bookingid", id);

			// to get the Thread Count to get the Parallel Execution
			System.out.println("Thread ID is : -------> " + Thread.currentThread().getId() + "Create Booking ID ---> "
					+ ThreadLocalDataStroeAsMap.getValue("bookingid"));
		}

		@Test(priority = 2)
		public void retrieveBooking() {

			// to get the Thread Count to get the Parallel Execution
			System.out.println("Thread ID is : -------> " + Thread.currentThread().getId() + 
			"Retrieved  Booking ID ---> " + ThreadLocalDataStroeAsMap.getValue("bookingid"));

			// Retrieve the Booking Id from the Map - whose return type is Object and cast it
			
			int book_id = (int) ThreadLocalDataStroeAsMap.getValue("bookingid");

			// Now call another Get booking Method to retrieve the Booking Id - and get the
			// Response and get the Booking ID
			Response response = RestAssured.given().log().all().contentType(ContentType.JSON)
					// Hit the Request and get the Response
					.get("https://restful-booker.herokuapp.com/booking/" + book_id)
					// validate the response
					.then().log().all().statusCode(200)
					// extract the response and get the Integer Booking Id from the Response
					.extract().response();

			// Use JSON Path to retrieve the firstname payload values
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



