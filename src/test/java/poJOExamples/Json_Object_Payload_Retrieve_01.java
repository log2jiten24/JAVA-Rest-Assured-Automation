package poJOExamples;

import io.restassured.RestAssured;

public class Json_Object_Payload_Retrieve_01 {

	public static void main(String[] args) {
	
		//Create the object of the POJO Class
		Json_Object_Payload_Creation_01 obj = new Json_Object_Payload_Creation_01() ;
		
		//set the payload values for the payload
		obj.setAccountNum(507221);
		obj.setBalance(236.96);
		obj.setEmail("log2jeet24@gmail.com");
		obj.setFname("Kumar");
		obj.setGender("Male");
		obj.setLname("Jitendra");
		
		//Form the request body and send the request and doing serializing into the JSON 
		
		RestAssured
		           .given()
		                   .log()
		                   .all()
		                   .body(obj)
		                             .when()
		                                     .get() ;
		

	}

}
