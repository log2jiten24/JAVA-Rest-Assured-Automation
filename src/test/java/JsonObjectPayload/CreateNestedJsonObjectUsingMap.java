package JsonObjectPayload;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateNestedJsonObjectUsingMap {

	public static void main(String[] args) {
		
		
		// Using LinkedHashMap - to store the values in the sorted order
				Map<String, Object> newLinkedHashMap = new LinkedHashMap<String, Object>();

				// store all the JSON values inside the Map
				newLinkedHashMap.put("id", "01");
				newLinkedHashMap.put("firstname", "Kumar");
				newLinkedHashMap.put("lastname", "Jitendra");
				newLinkedHashMap.put("age", "32");
				newLinkedHashMap.put("email", "log2jeet24@gmail.com");

				
				//create Another Map to store the Address values 
				Map<String , Object> addressMap = new LinkedHashMap<String , Object> ();
				addressMap.put("Street Num", "Ashton Street");
				addressMap.put("Flat Num", "32");
				addressMap.put("Suburb", "Kogarah");
				addressMap.put("City", "Sydney");
				addressMap.put("Post Code", "2216");
				//Add the nested Details 
				newLinkedHashMap.put("address", addressMap);
				
				newLinkedHashMap.put("gender", "male");
				newLinkedHashMap.put("married", true);
				newLinkedHashMap.put("salary", 234.3);
				
				
				RestAssured.given().log().all()
				// pass the body from the values stored inside the Java Map
				// .body(json_ObjectMap)
				//.body(newMap)
		        .body(newLinkedHashMap)
				.get();
				
	}

}
