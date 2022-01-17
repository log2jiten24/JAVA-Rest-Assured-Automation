package restAPIExamples;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class StaticVariables {
	
	@BeforeClass
	public void setUpRequestSpec() {
		
		//add the request Specification which is common 
		
		
		 RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		 RestAssured.basePath = "booking" ;
		 RestAssured.requestSpecification = RestAssured.given().log().all();
		 System.out.println ("Inital Set up");
		  
		  //add the Response Specification code which is common - for the status code , 
		  //JSON response type, for the time less than 6 seconds
			 
		 RestAssured.responseSpecification = RestAssured.expect().statusCode(200)
				                             .contentType(ContentType.JSON)
				                             .expect().time(Matchers.lessThan(6000L));
				                            
	}
	
	@Test
	public void staticvariables_implement () {
		
		RestAssured
		           .given()
		           .body("{\r\n" + "    \"firstname\" : \"Jiteeen001000\",\r\n" + "    \"lastname\" : \"Brewown02222201\",\r\n"
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
		             .all();
				          
		
	}

}
