package nestedJSONExamples;

import io.restassured.RestAssured;

public class NestedJSONObject_POJO_Class_Retrieve {

	public static void main(String[] args) {
		
		//Create One Object of the POJO Class
		NestedJSONObject_POJO_Class_Creation obj = new NestedJSONObject_POJO_Class_Creation() ;
		
		obj.setFirstname("Kumar");
		obj.setLastname("Jitendra");

        
		//Create another Object of the Address POJO Class and store the Address Nested JSON  values 
		NestedJSONObject_POJO_Class_Creation_02  address = new NestedJSONObject_POJO_Class_Creation_02() ;
		
		address.setFlatNum(87);
		address.setStreetName("Ashton Street");
		address.setState("NSW");
		address.setPostcode(2216);
		address.setCity("Rockdale");
		
		//pass the Address object inside the setAddress method
		obj.setAddress(address);
		obj.setGender("male");
		
		//Form the request body and send the request and doing serializing into the JSON 
		RestAssured
		           .given()
		                   .log()
		                   .all()
		                   //pass the object values to form the JSON Payload 
		                   .body(obj)
		                             .when()
		                                     .get() ;
		
		
	}

}
