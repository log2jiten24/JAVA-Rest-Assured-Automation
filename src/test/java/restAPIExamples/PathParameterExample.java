package restAPIExamples;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PathParameterExample {

	public static void main(String[] args) {
		
		
		//passing the Path Parameter 
		//Build the Request 
		RestAssured
		           .given()
		                    .log()
		                    .all()
		                    .baseUri("https://restful-booker.herokuapp.com/")
		                    //passing Parameter 
		                    .basePath("{basePath}/{bookingId}")
		                    //Parameterizing the value 
		                    .pathParam("basePath", "booking")
		                    .pathParam("bookingId", "10")
		                    .contentType(ContentType.JSON)
		            .when()
		                     //hit the Request
		                     .get()
		            .then()
		                     //validate the request 
		                     .log()
		                     .all()
		                     .statusCode(200);
		            
		
		System.out.println ("---------------------------------------------------------------------------------------");
		//Alternate way of passing path and query parameter
		
		//Build the Request 
				RestAssured
				           .given()
				                    .log()
				                    .all()
				                    .baseUri("https://restful-booker.herokuapp.com/")
				                    //passing Parameter 
				                    .basePath("{basePath}/{bookingId}")
				                    //Parameterizing the value 
				                    //.pathParam("basePath", "booking")
				                    //.pathParam("bookingId", "13")
				                    .contentType(ContentType.JSON)
				            .when()
				                     //hit the Request and Parameterize the value
				                     .get("https://restful-booker.herokuapp.com/{basePath}/{bookingId}", "booking", 11 )
				            .then()
				                     //validate the request 
				                     .log()
				                     .all()
				                     .statusCode(200);
				System.out.println ("---------------------------------------------------------------------------------------");
				//Alternate way of passing path and query parameter using Map -where we can store multiple Path Parameters 
				
				Map <String , Object> myPathParameters = new HashMap<String , Object>();
				//storing all the Path Parameters inside the Map - String and the value as Object
				myPathParameters.put("basePath", "booking");
				myPathParameters.put("bookingId", 11);
				
				
				//Build the Request 
						RestAssured
						           .given()
						                    .log()
						                    .all()
						                    .baseUri("https://restful-booker.herokuapp.com/")
						                    //passing Parameter 
						                    .basePath("{basePath}/{bookingId}")
						                    //taking the path parameter values from the Map
						                    .pathParams(myPathParameters)
						                    .contentType(ContentType.JSON)
						            .when()
						                     //hit the Request and Parameterize the value
						                     .get()
						            .then()
						                     //validate the request 
						                     .log()
						                     .all()
						                     .statusCode(200);
		
		                    
		         

	}

}
