package restAPIExamples;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class PutMethod_Update {

	public static void main(String[] args) {
	
		//Put Request - to update an existing  resource in the server and if the resource is not found, it will always create new resource 
		
		RestAssured.
		            given()
		                   .log()
		                   .all()
		                   .baseUri("https://restful-booker.herokuapp.com/")
		                   //passing  the parameters 
		                   .basePath("{basePath}/{bookingId}")
                           .pathParam("basePath", "booking")
                           .pathParam("bookingId", 11)
                           //pass the headers value inside the request 
                           .header("Content-type" , "application/json")
                           .headers("Authorization" , "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                           .body("{\r\n" + 
                           		"    \"firstname\" : \"JamesMilan\",\r\n" + 
                           		"    \"lastname\" : \"Brown\",\r\n" + 
                           		"    \"totalprice\" : 111,\r\n" + 
                           		"    \"depositpaid\" : true,\r\n" + 
                           		"    \"bookingdates\" : {\r\n" + 
                           		"        \"checkin\" : \"2018-01-01\",\r\n" + 
                           		"        \"checkout\" : \"2019-01-01\"\r\n" + 
                           		"    },\r\n" + 
                           		"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
                           		"}")
                    .when()
                           //hit the request 
                           .put()
                    //Validate the response 
                    .then()
                           .log()
                           .all()
                           .assertThat()
                           .statusCode(200);
	
		System.out.println ("----------------------------------------------------------------------------------------------");
		
		//Another alternative way of doing it 
		//Create Map for Parameters and the Header values 
		Map<String, Object> paramdetails = new HashMap<String , Object> ();
		//store the value inside the HashMap
		paramdetails.put("basePath", "booking");
		paramdetails.put("bookingId", 12);
		
		Map<String , Object> headerdetails = new HashMap<String , Object>();
		//adding header details inside the Map
		headerdetails.put("Content-type", "application/json");
		headerdetails.put("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
		
		
		
		RestAssured.
                   given()
                          .log()
                          .all()
                          .baseUri("https://restful-booker.herokuapp.com/")
                           //passing  the parameters 
                          .basePath("{basePath}/{bookingId}")
                          //.pathParam("basePath", "bookingId")
                          //pass the header parameters from the Map 
                          .pathParams(paramdetails)
                          //adding Parameters 
                          .headers(headerdetails)
                          .body("{\r\n" + 
                          		"    \"firstname\" : \"Vivek\",\r\n" + 
                          		"    \"lastname\" : \"Brown\",\r\n" + 
                          		"    \"totalprice\" : 111,\r\n" + 
                          		"    \"depositpaid\" : true,\r\n" + 
                          		"    \"bookingdates\" : {\r\n" + 
                          		"        \"checkin\" : \"2018-01-01\",\r\n" + 
                          		"        \"checkout\" : \"2019-01-01\"\r\n" + 
                          		"    },\r\n" + 
                          		"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
                          		"}")
                     .when()
                              .put()
                          //validate the response 
                       .then()
                              .log()
                              .all()
                              .assertThat()
                              .statusCode(200);
                                 
                          
                          
		
                           

	}

}
