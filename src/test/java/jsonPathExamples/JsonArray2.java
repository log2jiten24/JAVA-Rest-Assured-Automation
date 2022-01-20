package jsonPathExamples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.restassured.path.json.JsonPath;

public class JsonArray2 {

	public static void main(String[] args) {
		
		
		String jsonFile = "{\r\n" + 
				"  \"query\" : {\r\n" + 
				"    \r\n" + 
				"    \"ids\" : [\r\n" + 
				"      {\r\n" + 
				"        \"cgid\" : \"200020084698\" \r\n" + 
				"      },\r\n" + 
				"      \r\n" + 
				"      {\r\n" + 
				"        \"cgid\" : \"200020084694\" \r\n" + 
				"      },\r\n" + 
				"      \r\n" + 
				"      {\r\n" + 
				"        \"cgid\" : \"200020084697\" \r\n" + 
				"      }\r\n" + 
				"      \r\n" + 
				"      \r\n" + 
				"      ]\r\n" + 
				"  }\r\n" + 
				"  \r\n" + 
				"  \r\n" + 
				"}" ;
		
		JsonPath jsonPath = new JsonPath(jsonFile);
		//to fetch the particular array value with the index value 
		System.out.println ("Json Array value :" + jsonPath.getString("query.ids"));
		//to get the size of the whole array list -it will return the whole array list and its size 
		//System.out.println ("Arraylist size :" + jsonPath.getList("$").size() );
		System.out.println ("Json Array value :" + jsonPath.getString("query.ids[0]"));
		
		//Object Array =  (Object) jsonPath.getString("query.ids");
		
		// json we wanted to find the first name whose gender is female
	   List<String>allcg_id = jsonPath.getList("query.ids.cgid");
       System.out.println("allcgid :" + allcg_id);
       
       List<String>allcgs = jsonPath.getList("query.ids");
       
      
//       // converting List<String> to String using toString() method
//       String stringFromList = allcgs.toString();
//        
//       // printing the string
//      stringFromList.replaceAll("cgid", "cgid-")   ;
//      
//      System.out.println ("String id :" + stringFromList);
       
       Object[] arrayOfString = allcgs.toArray(); 
       
       List<Object> listOfNames = Arrays.asList(arrayOfString); 
       
       System.out.println("5th example of Stream to List in Java 8 : " + listOfNames.get(0));

       
      
		
	

	}

}
