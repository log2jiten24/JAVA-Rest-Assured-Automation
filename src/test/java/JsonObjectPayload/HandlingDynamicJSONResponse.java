package JsonObjectPayload;


import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HandlingDynamicJSONResponse {

	public static void main(String[] args) {
		
		//Concept of De-serialization 
		//Response response = RestAssured.
		                                // get("https://run.mocky.io/v3/2ab9b97b-926a-41ee-87e3-f18e5de6da18");
		//storing the response inside the Map
		//Map<String , Object> all_details_Map  = response.as(Map.class);
		//printing all the key values inside the Map
		//System.out.println ("Map Details :" + all_details_Map.keySet());
		
		//Following Error is being seen > Exception in thread "main" com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot deserialize value of type `java.util.LinkedHashMap<java.lang.Object,java.lang.Object>` 
		//from Array value (token `JsonToken.START_ARRAY`)//mismatch Input Exceptions
		
		//this error signifies that this is JSON Array and it cannot be converted to Map - we need to handle it dynamically 
		                                 
		System.out.println ("-----------------------Handle Dynamic Response whether Array or MAP--------------------------") ;
		
		  
		Response response  = RestAssured.
		                        get("https://run.mocky.io/v3/2ab9b97b-926a-41ee-87e3-f18e5de6da18");
		
		//Storing the response inside the Object Instance - as Object Instance is Super Class
		//Class Object is the root of the class hierarchy.Every class has Object as a superclass. 
		//All objects,including arrays, implement the methods of this class
		Object responseAsObject =  response.as(Object.class);
		
		if (responseAsObject instanceof  List) {
		//Add down casting 	
		List   responseAsList =	 (List) responseAsObject;
		
		System.out.println ("size of list :" + responseAsList.size());
		
		System.out.println ("Array list values:" + responseAsList.get(0) );
		
		//to get each value of key and value - convert the list into the Map 
		Map<String, Object>  all_Map = (Map<String, Object>) responseAsList.get(0);
	     System.out.println ("printing all the keysets of the map" + all_Map.keySet())	;
	     
	     System.out.println ("printing all the values of the map" + all_Map.values())	;
	     
		 } else if (responseAsObject instanceof Map) {
			 
		//if the response is JSON Object - then it will be directly executed as Map 	
		Map mapResponse  = (Map) responseAsObject;
			
		System.out.println ("printing all the keysets of the map" + mapResponse.keySet())	;
		
		}		
	            }
                    }
