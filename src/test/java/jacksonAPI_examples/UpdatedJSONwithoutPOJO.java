package jacksonAPI_examples;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import poJOExamples.POJO_Class_Creation;

public class UpdatedJSONwithoutPOJO {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {

		// Class ObjectMapper helps to convert JSON Object to POJO and from POJO to JSON
		// Object

		ObjectMapper objMapper = new ObjectMapper();

		// readValue - method pass the FilePath and change to TypeReference -store the
		// values to Map - use TypeReference Abstract Class
		// using Anonymous Object to convert to Map
		Map<String, Object> all_Map_values = objMapper.readValue(
				new File("F:\\Cucumber6Series\\RestAssuredProject\\resources\\address.json"),
				new TypeReference<Map<String, Object>>() {
				});

		
		//Update new values to the Map 
		all_Map_values.put("country", "Australia");
		all_Map_values.put("firstname", "Priya");
		
		//add new value to the Map
		all_Map_values.put("State", "NSW");
		
		String updated_JSON = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(all_Map_values);
		 
		System.out.println ("Formatted JSON Value :" + updated_JSON);

		
		// to get the Specific key value from the JSON
		System.out.println(all_Map_values.get("country"));
		System.out.println(all_Map_values.get("firstname"));
		System.out.println(all_Map_values.get("State"));
		
		// to get all the values from the Map
		System.out.println("All Map Values :" + all_Map_values.values());
		// to get all the key from the Map
		System.out.println("All Map Key Values :" + all_Map_values.keySet());

		Collection<Object> all_map_values = all_Map_values.values();
		
		// Print the first map values
		Iterator<Object> all_Obj = all_map_values.iterator();

		while (all_Obj.hasNext()) {

			System.out.println("Print all the Map values " + all_Obj.next());
		}

		//Print all  the key values 
		Set<String> all_keys = all_Map_values.keySet();

		Iterator<String> all_key_values = all_keys.iterator();
		while (all_key_values.hasNext()) {

			System.out.println("Print all the Map Keys  " + all_key_values.next());
		}

	}

}
