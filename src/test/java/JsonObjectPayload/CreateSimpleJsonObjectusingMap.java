package JsonObjectPayload;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateSimpleJsonObjectusingMap {

	public static void main(String[] args) {

		Map<String, String> json_ObjectMap = new HashMap<String, String>();

		// Generic Map to store any data type value - Object data type is the Super
		// class and it can store any data type
		Map<String, Object> newMap = new HashMap<String, Object>();

		// Using LinkedHashMap - to store the values in the sorted order
		Map<String, Object> newLinkedHashMap = new LinkedHashMap<String, Object>();

		// store all the JSON values inside the Map
		json_ObjectMap.put("id", "01");
		json_ObjectMap.put("firstname", "Kumar");
		json_ObjectMap.put("lastname", "Jitendra");
		json_ObjectMap.put("age", "32");
		json_ObjectMap.put("email", "log2jeet24@gmail.com");
		json_ObjectMap.put("gender", "male");
		json_ObjectMap.put("married", "true");
		json_ObjectMap.put("salary", "234.3");

		// Map to store any data type values inside the Map
		// store all the JSON values inside the Map
		newMap.put("id", 01);
		newMap.put("firstname", "Kumar");
		newMap.put("lastname", "Jitendra");
		newMap.put("age", 32);
		newMap.put("email", "log2jeet24@gmail.com");
		newMap.put("gender", "male");
		newMap.put("married", true);
		newMap.put("salary", 234.3);

		// Map to store any data type values inside the Map
		// store all the JSON values inside the Map
		newLinkedHashMap.put("id", 01);
		newLinkedHashMap.put("firstname", "Kumar");
		newLinkedHashMap.put("lastname", "Jitendra");
		newLinkedHashMap.put("age", 32);
		newLinkedHashMap.put("email", "log2jeet24@gmail.com");
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
