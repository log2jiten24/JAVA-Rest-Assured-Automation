package jacksonAPI_examples;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import poJOExamples.POJO_Class_Creation;
import poJOExamples.POJO_Class_Creation_02;

public class JsonInclude_Examples {

	public static void main(String[] args) throws Exception {
		
		
		//POJO_Class_Creation obj1 = new POJO_Class_Creation ();
		
		//create the object of the child class 
		
		POJO_Class_Creation_02 obj1 = new POJO_Class_Creation_02 ();
		obj1.setFirstname("Vivek");
		obj1.setLastname("Simran");
		//obj1.setAge(31);
		//obj1.setGender("female");
		obj1.setSalary(563.36);
		obj1.setCountry("INDIA");
		
		//set the empty list and the Map
		obj1.setSkillSet(new ArrayList<>());
		//set Empty HashMap
		obj1.setFamilyMembers(new HashMap<String, Object>());
		
		//set the skills for the child class 
		obj1.setSkills("Programming");
		
		//Convet JSON Object to the String
		ObjectMapper objMapper = new ObjectMapper();
		String updated_JSON = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj1);
		
		System.out.println ("Formatted JSON Value :" + updated_JSON);

	}

}
