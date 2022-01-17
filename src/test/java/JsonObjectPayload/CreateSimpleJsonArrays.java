package JsonObjectPayload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;


public class CreateSimpleJsonArrays {

	public static void main(String[] args) {
		
		
		Map<String , Object> newMap = new LinkedHashMap<String , Object > ();
		
		newMap.put("id", 1) ;
		newMap.put("first_name", "Cynde") ;
		newMap.put("last_name", "Feldhuhn") ;
		newMap.put("email", "cfeldhuhn0@spiegel.de") ;
		newMap.put("gender", "Female") ;
		newMap.put("city", "Daykitin") ;
		
		//store another JSON Object inside the Map
        Map<String , Object> newMap2 = new LinkedHashMap<String , Object > ();
		
        newMap2.put("id", 2) ;
        newMap2.put("first_name", "Kumar") ;
        newMap2.put("last_name", "Jiten") ;
        newMap2.put("email", "cfeldhuhn0gmail.com") ;
        newMap2.put("gender", "Male") ;
        newMap2.put("city", "Sydney") ;
		
		//create an array list - List  storing the json value object of the map inside the Array List 
		//give the generic data type for the list as Map
		List<Map<String , Object>> all_list = new ArrayList <>();
		//inside the list store the json object of the map
		all_list.add(newMap);
		//inside the list store the second JSON Object 
		all_list.add(newMap2);
		
		RestAssured.
		            given()
		            .log()
		            .all()
		            //pass the body -JSON object stored in the form of array
		            .body(all_list)
		            .get();
		

	}

}
