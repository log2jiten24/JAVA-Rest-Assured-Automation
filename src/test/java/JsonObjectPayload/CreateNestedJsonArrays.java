package JsonObjectPayload;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;

import io.restassured.RestAssured;

public class CreateNestedJsonArrays {

	public static void main(String[] args) {

		Map<String , Object> mapdetails = new LinkedHashMap<String , Object> ();
		mapdetails.put("id", 1);
		mapdetails.put("first_name", "Cynde");
		mapdetails.put("last_name", "Feldhuhn");
		mapdetails.put("email", "cfeldhuhn0@spiegel.de");
		mapdetails.put("gender", "Female");
		mapdetails.put("city", "Daykitin");
		
		List<String> mobileNumbers = new ArrayList<String> ();
		//add the mobile Numbers 
		mobileNumbers.add("0405009374");
		mobileNumbers.add("8879551929") ;
		
		//add the mobile details inside the Map
		mapdetails.put("mobile", mobileNumbers);
		
		//Another alternative way to add the elements inside the array list - in one line we can add all the details
		List<String> devicesList = java.util.Arrays.asList("Android" , "iOS");
		//add the device list inside the Map
		mapdetails.put("devices", devicesList);
		
		Map<String , Object> skilldetails = new LinkedHashMap<String , Object> ();
		skilldetails.put("name", "Testing");
		skilldetails.put("proficency", "medium");
		
		mapdetails.put("skills", skilldetails);
		
		//Another map to add the second JSON Object 
		Map<String , Object> mapdetails2 = new LinkedHashMap<String , Object> ();
		mapdetails2.put("id", 2);
		mapdetails2.put("first_name", "Jiten");
		mapdetails2.put("last_name", "Kumar");
		mapdetails2.put("email", "cfeldhuhn@gmail.com");
		mapdetails2.put("gender", "male");
		mapdetails2.put("city", "Sydney");
		
		List<String> mobileNumbers2 = new ArrayList<String> ();
		//add the mobile Numbers 
		mobileNumbers2.add("0405009372");
		mobileNumbers2.add("8879551921") ;
		
		//add the mobile details inside the Map
		mapdetails2.put("mobile", mobileNumbers2);
		
		//Another alternative way to add the elements inside the array list - in one line we can add all the details
		List<String> devicesList2 = java.util.Arrays.asList("One Plus" , "iOS");
		//add the device list inside the Map
		mapdetails2.put("devices", devicesList2);
		
		Map<String , Object> skilldetails2 = new LinkedHashMap<String , Object> ();
		skilldetails2.put("name", "Testing");
		skilldetails2.put("proficency", "medium");
		
		mapdetails2.put("skills", skilldetails2);

		List<Map <String, Object>> final_list = new ArrayList<Map <String , Object>> () ;
		//Add all the json object values inside the array list 
		final_list.add(mapdetails);
		final_list.add(mapdetails2);
		
		RestAssured.
                    given()
                    .log()
                    .all()
        //pass the body -JSON object stored in the form of array
                   .body(final_list)
                   .get();

	}

}
