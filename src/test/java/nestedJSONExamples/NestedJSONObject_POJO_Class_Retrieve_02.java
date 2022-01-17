package nestedJSONExamples;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class NestedJSONObject_POJO_Class_Retrieve_02 {
	
	public static void main(String[] args) {
		
		
		//Create One Object of the POJO Class
		NestedJSONObject_POJO_Class_Creation_03_ArrayCreation obj = new NestedJSONObject_POJO_Class_Creation_03_ArrayCreation() ;
				
				obj.setFirstname("Kumar");
				obj.setLastname("Jitendra");

		        
				//Create another Object of the Address POJO Class and store the Address Nested JSON  values 
				NestedJSONObject_POJO_Class_Creation_02  address = new NestedJSONObject_POJO_Class_Creation_02() ;
				
				address.setFlatNum(87);
				address.setStreetName("Ashton Street");
				address.setState("NSW");
				address.setPostcode(2216);
				address.setCity("Rockdale");
				
				//Create another Object of the Address POJO Class and store the Address Nested JSON  values 
				NestedJSONObject_POJO_Class_Creation_02  address2 = new NestedJSONObject_POJO_Class_Creation_02() ;
				
				address2.setFlatNum(25);
				address2.setStreetName("Green Street");
				address2.setState("NSW");
				address2.setPostcode(2217);
				address2.setCity("Kogarah");
				
				//now we need to store the list of addresses inside the Array List - list generic type should be class type 
				List<NestedJSONObject_POJO_Class_Creation_02> all_address_list = new ArrayList<>() ;
				//add the addresses object inside the list
				all_address_list.add(address);
				all_address_list.add(address2);
				
				//now store the list values inside the method 
				obj.setAddresses(all_address_list);
				
				
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
