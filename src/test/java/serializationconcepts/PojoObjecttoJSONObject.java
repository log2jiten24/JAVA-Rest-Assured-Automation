package serializationconcepts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoClasses.PersonPOJO;

public class PojoObjecttoJSONObject {
	
	public static void main (String [] args) throws JsonProcessingException {
		
		PersonPOJO person_obj = new PersonPOJO() ;
		
		person_obj.setAge("32");
		person_obj.setName("Jiten");
		
		//Java Serialization concept is used to convert the POJO Class Object to the JSON Object 
		
		ObjectMapper obj = new ObjectMapper();
		
		String jsonString = obj.writerWithDefaultPrettyPrinter().writeValueAsString(person_obj);
		
		System.out.println ("Updated JSON value :" + jsonString);
		
	}

}
