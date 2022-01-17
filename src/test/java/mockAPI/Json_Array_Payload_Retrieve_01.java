package mockAPI;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import poJOExamples.Json_Object_Payload_Creation_01;

public class Json_Array_Payload_Retrieve_01 {
	
	
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
			
			//Create another object of the POJO Class
			Json_Object_Payload_Creation_01 obj1 = new Json_Object_Payload_Creation_01() ;
			
			//set the payload values for the payload
			obj1.setAccountNum(5072244);
			obj1.setBalance(2400.96);
			obj1.setEmail("log2jiten24@gmail.com");
			obj1.setFname("Priyaa");
			obj1.setGender("Female");
			obj1.setLname("Jeet");
			
			//Create an ArrayList to store all the two JSON Objects inside the ArrayList for which the List type should be Class
			
			List<Json_Object_Payload_Creation_01> all_json_values = new ArrayList<Json_Object_Payload_Creation_01>();
			//store all the JSON Object values to form as JSON Array 
			all_json_values.add(obj);
			all_json_values.add(obj1);
			
			//Form the request body and send the request and doing serializing into the JSON 
			RestAssured
			           .given()
			                   .log()
			                   .all()
			                   //pass the arraylist values to form the JSON Payload 
			                   .body(all_json_values)
			                             .when()
			                                     .get() ;
			
			
			
			
			
			
			
			
	  
			
			
	
	  }
	

}
