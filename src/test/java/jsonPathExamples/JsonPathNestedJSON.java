package jsonPathExamples;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathNestedJSON {
	
	@Test
	public void jsonPathDemo () {
		
	String json = "{\r\n" + 
			"  \"firstname\" : \"Jiten\",\r\n" + 
			"  \"lastname\" : \"Kumar\",\r\n" + 
			"  \"age\" : 32,\r\n" + 
			"  \"address\" :{\r\n" + 
			"    \"flatNumber\" : 87,\r\n" + 
			"    \"StreetName\" : \"Ashton Street\",\r\n" + 
			"    \"Suburb\"     : \"Rockdale\",\r\n" + 
			"    \"City\"       : \"Sydney\"\r\n" + 
			"  },\r\n" + 
			"  \"salary\"  :10.5 ,\r\n" + 
			"  \"married\" : true\r\n" + 
			"  \r\n" + 
			"  \r\n" + 
			"}" ;
	
	//Usage of Json Path to fetch the value of the first name 
	//Get the JSON Path Instance of the given Json Format - pass the String in the constructor reference of the JsonPath class 
	
	JsonPath jsonPath = new JsonPath(json);
	
    int address_flatnum = jsonPath.getInt("address.flatNumber");
    String Street_Name   = jsonPath.getString("address.StreetName");
    String Suburb       =  jsonPath.getString("address.Suburb");
    String City          =  jsonPath.getString("address.City");
    boolean married    = jsonPath.getBoolean("married");
	
   System.out.println ("Address flatnum :" + address_flatnum + "Street_Name :" + Street_Name + "Suburb :" + Suburb + " " +
		   "City name - " + City + " " + "married :" + married) ;
   
}


}
