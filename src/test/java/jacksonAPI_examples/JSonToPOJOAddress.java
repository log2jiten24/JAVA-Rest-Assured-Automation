package jacksonAPI_examples;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import poJOExamples.POJO_Class_Creation;

public class JSonToPOJOAddress {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		
		//Class ObjectMapper helps to convert JSON Object to POJO and from POJO to JSON Object
		
		ObjectMapper objMapper = new ObjectMapper();
		
		//readValue - method pass the FilePath and the Class Path where the POJO values are stored for the JSON File
		POJO_Class_Creation  objvalues   = objMapper.readValue(new File("F:\\Cucumber6Series\\RestAssuredProject\\resources\\address.json"), 
		POJO_Class_Creation.class);
		
		//Now set the JSON values into new values 
		objvalues.setFirstname("Priya");
		objvalues.setLastname("Kumar");
		objvalues.setAge(25);
		objvalues.setGender("female");
		objvalues.setSalary(633.63);

		
		//Now retrieve the values from the JSON File 
		System.out.println ("JSON Array Values :" + objvalues.getFirstname() + "-" + objvalues.getLastname()
		+ "-" + objvalues.getCountry() + "-" + objvalues.getGender() + " " + objvalues.getSalary() + " "
		) ;
		//update the country 
		objvalues.setCountry("INDIA");
		//to update runtime the JSON Payload
		String updated_JSON = objMapper.writeValueAsString(objvalues);
		
		System.out.println ("Updated JSON Value :" + updated_JSON);
		
		//to print the JSON value with proper format
		 updated_JSON = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objvalues);
		 
		 System.out.println ("Formatted JSON Value :" + updated_JSON);

	}

}
