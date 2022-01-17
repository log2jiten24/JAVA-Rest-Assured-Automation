package JsonObjectPayload;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertJSONObjectPayloadResponsetoMap {

	public static void main(String[] args) {
		
		
		//De-serialize Concept - on how to break the JSON Response and convert it into the MAP 
		
		Map jsonResponseasMap = RestAssured.
        given()
               
               //give the Mock URL where we want to Mock the API URL  Response -end point url 
               .get("https://run.mocky.io/v3/52215d25-6963-4c28-9df2-f14f88d51e59")
               .as(Map.class) ;
		
		//get the firstname values from the JSON Object Key 
		String fname = (String) jsonResponseasMap.get("first_name");
		System.out.println ("firstname is -" + " " + fname);
        
		//to get all the key values from the Map and to iterate over each key pair
		jsonResponseasMap.keySet().forEach(k -> System.out.println (k));
		
		jsonResponseasMap.values().forEach(values ->System.out.println (values));
		
		System.out.println ("------------------------------------NESTED JSON PART ------------------------------------------") ;
		
		Map jsonResponseasMap2 = RestAssured.
		        given()
		               
		               //give the Mock URL where we want to Mock the API URL  Response -end point url 
		               .get("https://run.mocky.io/v3/d2cd2fe3-d231-44b3-afb0-3c97504b4a6c")
		               .as(Map.class) ;
		
		   //storing the nested json of skills into another MAp - whose return type is also Map
		    Map<String , String> skillsMap = (Map<String , String>) jsonResponseasMap2.get("skills") ;
		   //get the value for each of the nested Json Object key pairs  
		   System.out.println (skillsMap.get("name"));
		   System.out.println (skillsMap.get("proficency"));
		
		   System.out.println ("------------------------------------PASS Map as Generic part  ------------------------------------------") ;
		   
		   Map <String , Object >jsonResponseasMap3 = RestAssured.
			        given()
			               
			               //give the Mock URL where we want to Mock the API URL  Response -end point url 
			               .get("https://run.mocky.io/v3/52215d25-6963-4c28-9df2-f14f88d51e59")
			               //give the Map Generic part
			               .as(new TypeRef<Map<String,Object>>() {});
						
					
					//get the firstname values from the JSON Object Key 
					String fname2 = (String) jsonResponseasMap3.get("first_name");
					System.out.println ("firstname is -" + " " + fname2);
			        
					//to get all the key values from the Map and to iterate over each key pair
					jsonResponseasMap3.keySet().forEach(k -> System.out.println (k));
					
					jsonResponseasMap3.values().forEach(values ->System.out.println (values));
		   
	}

}
