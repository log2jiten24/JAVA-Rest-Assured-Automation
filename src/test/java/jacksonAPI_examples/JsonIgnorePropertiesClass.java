package jacksonAPI_examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import poJOExamples.Employee_POJO_2;
import poJOExamples.Employee_POJO_Class;

public class JsonIgnorePropertiesClass {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
	
		
		String jsonString = "{\r\n" + 
				"  \"id\": 87,\r\n" + 
				"  \"name\": \"Kumar\",\r\n" + 
				"  \"mobNum\": \"0405009374\",\r\n" + 
				"  \"deptId\": 240,\r\n" + 
				"  \"address\": \"Sydney\",\r\n" + 
				"  \"married\" : true\r\n" + 
				"}";
		
		//Deserializing  Concepts = to convert the JSON Object Response to the POJO Class and to fetch the value from the JSON 
		
		ObjectMapper obj = new ObjectMapper();//create object of the ObjectMapper class 
		//with the help of ObjectMapper object read the JSON value from the String and pass parameter as POJO CLASS which is having 
		//the JSON Values and store it inside the object of the Employee_POJO_Class 
		
		Employee_POJO_2 empObj = obj.readValue(jsonString, Employee_POJO_2.class);//example of Deserialization
		//Fetch all the values from the JSON file 
		System.out.println (empObj.getId());
		System.out.println (empObj.getName());
		System.out.println (empObj.getMobNum());
		System.out.println (empObj.getDeptId());
		System.out.println (empObj.getAddress());
		System.out.println (empObj.isMarried());
		
		
		
		
		

	}

}
