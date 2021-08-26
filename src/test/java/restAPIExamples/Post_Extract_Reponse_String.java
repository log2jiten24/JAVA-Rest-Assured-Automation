package restAPIExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Post_Extract_Reponse_String {

	public static void main(String[] args) {

		String Responsebody = 
				RestAssured
				.given()
				        .baseUri("https://restful-booker.herokuapp.com/")
				        .basePath("booking")
				        .body("{\r\n" + "    \"firstname\" : \"Jiten007\",\r\n" + "    \"lastname\" : \"Brewown001\",\r\n"
						+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
				        .contentType(ContentType.JSON)
				.when()
				// Hit the request
				       .post()
				.then()
				// validate the response code
				       .statusCode(200)

				// extract the response and store it inside the string
				        .extract()
				        //.body()
				// give the response body in the pretty string format
				        .asPrettyString();

		System.out.println("Extract Response from the body :" + Responsebody);

	}

}
