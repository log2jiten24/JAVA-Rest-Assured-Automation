package restAPIExamples;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Get_Method_BDD_Example {

	public static void main(String[] args) {
	
		//Build the request 
		
		RequestSpecification requestSpecification  = RestAssured.given().log().all();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		
		requestSpecification.basePath("booking/{id}");
		//pass the path parameter value which we want to retrieve 
		requestSpecification.pathParam("id", 13);
		
		//pass the Get Method - hit the method  
	    Response response =	requestSpecification.get();
	    
	    ValidatableResponse validateResp  = response.then().log().all();
	    //validate the status code 
	    validateResp.statusCode(200);
	    
	    
	    //Another way of doing it in format of method chaining
	    
	    RestAssured.given()
	                      .log()
	                       .all()
	                       .baseUri("https://restful-booker.herokuapp.com/")
	                       .basePath("booking/{id}")
	                       .pathParam("id", 10)
	                .when()
	                 //hit the request
	                       .get()
	                .then()
	                //validate the response 
	                       .log()
	                       .all()
	                       .statusCode(200);
	                       
	                       

	}

}
