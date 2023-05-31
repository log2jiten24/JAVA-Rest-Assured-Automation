package jacksonAPIDeserializerExamples;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoClasses.Practice_POJO_Class;

public class JsonIgnoreProperties_Deserialization {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		
		String json_response = "{\r\n" + 
				"\r\n" + 
				"  \"id\" :250,\r\n" + 
				"  \"name\" : \"KumarJiten\" ,\r\n" + 
				"  \"mobNum\" : \"0405009374\",\r\n" + 
				"  \"deptid\" : 24031990,\r\n" + 
				"  \"address\" :\"7 Plaza Drive \",\r\n" + 
				"  \"married\" : true,\r\n" + 
				"  \"skills\"  : \"Java\"\r\n" + 
				"  \r\n" + 
				"}";
		
		//Use ObjectMaper Class  from the Jackson API to deserialize the JSON Response
		ObjectMapper obj = new ObjectMapper () ;
		//Read the JSON Response by creating the POJO Class 
	   Practice_POJO_Class pract_Obj =  obj.readValue(json_response, Practice_POJO_Class.class);
		
	   System.out.println (pract_Obj.getId());
	   System.out.println (pract_Obj.getName());
	   System.out.println (pract_Obj.getMobNum());
	   System.out.println (pract_Obj.getDeptid());
	   System.out.println (pract_Obj.getAddress());
	   System.out.println (pract_Obj.isMarried());
   
	   //Other way of doing it by passing the Map Class 
	   Map<String , Object> all_values =  obj.readValue(json_response, Map.class);
		
		System.out.println ("String name :" +    all_values.get("name")) ;
		System.out.println ("String Deptid :" +  all_values.get("id")) ;
		System.out.println ("String MobNum :" +  all_values.get("mobNum")) ;
		System.out.println ("String MobNum :" +  all_values.get("deptid")) ;
		System.out.println ("String Address :" + all_values.get("address")) ;
		System.out.println ("Married Value:" +   all_values.get("married")) ;
	}

}
