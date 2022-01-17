package jsonPathExamples;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathSimpleJSON {
	
	
	@Test
	public void jsonPathDemo () {
		
	String json = "{\r\n" + 
			"    \"firstname\" : \"James\",\r\n" + 
			"    \"lastname\" : \"Brown\",\r\n" + 
			"    \"totalprice\" : 111,\r\n" + 
			"    \"finalprice\" : 111.89,\r\n" + 
			"    \"depositpaid\" : true,\r\n" + 
			"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
			"}" ;
	
	//Usage of Json Path to fetch the value of the first name 
	//Get the JSON Path Instance of the given Json Format - pass the String in the constructor reference of the JsonPath class 
	
	JsonPath jsonPath = new JsonPath(json);
	
	String fname  = jsonPath.getString("lastname");
	int price = jsonPath.getInt("totalprice");
	boolean dep_paid = jsonPath.getBoolean("depositpaid");
	float final_price = jsonPath.getFloat("finalprice");
	double finalprice = jsonPath.getDouble("finalprice");
	
	System.out.println ("firstname is :" + fname + " " + "price :"  + price + " " + "deposit paid :" + dep_paid + " " 
			+ "final_price :" + final_price + " " + "double final_price" + finalprice);
	

}
}