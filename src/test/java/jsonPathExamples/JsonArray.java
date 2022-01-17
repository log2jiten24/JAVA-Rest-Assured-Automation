package jsonPathExamples;

import java.util.List;

import io.restassured.path.json.JsonPath;

public class JsonArray {

	public static void main(String[] args) {
		
		
//		String json_Object = "[\r\n" + 
//				"  \r\n" + 
//				"  \"10\",\r\n" + 
//				"  \"20\",\r\n" + 
//				"  \"30\",\r\n" + 
//				"  \"40\",\r\n" + 
//				"  \"50\"\r\n" + 
//				"]";
		
		//Example of nested JSON Array 
        String json_Object = "[\r\n" + 
        		"  [\r\n" + 
        		"  \"10\",\r\n" + 
        		"  \"20\",\r\n" + 
        		"  \"30\",\r\n" + 
        		"  \"40\",\r\n" + 
        		"  \"50\"\r\n" + 
        		"  \r\n" + 
        		"],\r\n" + 
        		"[\r\n" + 
        		"   \"100\",\r\n" + 
        		"   \"200\",\r\n" + 
        		"  \"300\",\r\n" + 
        		"  \"400\",\r\n" + 
        		"  \"500\"\r\n" + 
        		"  ]\r\n" + 
        		"   ]";
		
		JsonPath jsonPath = new JsonPath(json_Object);
		//to fetch the particular array value with the index value 
		System.out.println ("Json Array value :" + jsonPath.getString("[1]"));
		//to get the size of the whole array list -it will return the whole array list and its size 
		System.out.println ("Arraylist size :" + jsonPath.getList("$").size() );
		
		//to fetch the 2nd aRRAY  json object value 
		System.out.println ("JSON Array values -2nd array value :" + jsonPath.getString("[1][2]"));
		
		//to get the particular aaraylist size
		List<Object> internalList = (List<Object>)jsonPath.getList("$").get(0);
		System.out.println ("Array list size :" + internalList.size()) ;

	}

}
