package serializationconcepts;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoClasses.PersonPOJO;

public class JSON_Deserialize_Response {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		
		String json_response = "{\r\n" + 
				"  \"name\" : \"Jiten\",\r\n" + 
				"  \"age\" : \"32\"\r\n" + 
				"}";
		
		ObjectMapper obj = new ObjectMapper();
		//read the request from the POJO Class and retrieve the payload values 
		PersonPOJO objResp = obj.readValue(json_response, PersonPOJO.class);
		
		System.out.println ("String name :" + objResp.getName()) ;
		System.out.println ("String age :" + objResp.getAge()) ;
		
		//Another alternate way is that if we are not doing it from POJO Class - we can do it for retrieving from Map 
		
		Map<String , Object> all_values =  obj.readValue(json_response, Map.class);
		
		System.out.println ("String name :" + all_values.get("name")) ;
		System.out.println ("String age :" +  all_values.get("age")) ;

	}

}
