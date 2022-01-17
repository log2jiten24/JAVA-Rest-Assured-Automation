package jsonPathExamples;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathDemo {
	
	
	
	@Test
	public void jsonPathDemo () {
	String json = "{\r\n" + 
			"    \"firstname\" : \"James\",\r\n" + 
			"    \"lastname\" : \"Brown\"\r\n" + 
			"}";
	
	//Usage of Json Path to fetch the value of the first name 
	//Get the JSON Path Instance of the given Json Format 
	
	JsonPath jsonPath = new JsonPath(json);
	//get the value of the first name from the JSON Value 
	String firstName = jsonPath.getString("firstname");
	
	System.out.println ("First name from the JSON Resp :" + firstName);
	
	//Alternate way of getting the value from the JSON is the get Method 
	Object fname =  jsonPath.get("firstname");
	System.out.println ("First Name value :" + fname);
	
	//Alternative , if we use $ as root node , it will print the  whole JSON Payload -caste it as object 
	System.out.println ((Object) jsonPath.get("$"));
	//{firstname=James, lastname=Brown}
	
	//Alternative way of fetching the data 
	System.out.println (jsonPath.getString("$"));
	//[firstname:James, lastname:Brown]
	
	//Alternative way to print the values
	System.out.println ((Object)jsonPath.get());
	
	//Alternative way to print the values
	System.out.println (jsonPath.getString(""));
	
}
	
}
