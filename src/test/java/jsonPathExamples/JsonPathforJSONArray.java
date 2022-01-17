package jsonPathExamples;

import java.util.List;

import io.restassured.path.json.JsonPath;

public class JsonPathforJSONArray {

	public static void main(String[] args) {
		
		String jsonArray = "[\r\n" + 
				"{\r\n" + 
				"  \"firstname\" : \"Jiten\",\r\n" + 
				"  \"lastname\" : \"Kumar\",\r\n" + 
				"  \"age\" : 32,\r\n" + 
				"  \"address\" :[\r\n" + 
				"    {\r\n" + 
				"    \"flatNumber\" : 87,\r\n" + 
				"    \"StreetName\" : \"Ashton Street\",\r\n" + 
				"    \"Suburb\"     : \"Rockdale\",\r\n" + 
				"    \"City\"       : \"Sydney\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"  \"salary\"  :10.5 ,\r\n" + 
				"  \"married\" : true,\r\n" + 
				"  \"town\" : \"Kogarah\",\r\n" + 
				"  \"City\"       : \"Melbourne\"\r\n" + 
				"  }\r\n" + 
				"   ]\r\n" + 
				"     },\r\n" + 
				"{\r\n" + 
				"  \"firstname\" : \"Priya\",\r\n" + 
				"  \"lastname\" : \"Singh\",\r\n" + 
				"  \"age\" : 26,\r\n" + 
				"  \"address\" :[\r\n" + 
				"    {\r\n" + 
				"    \"flatNumber\" : 97,\r\n" + 
				"    \"StreetName\" : \"Belgrave Street\",\r\n" + 
				"    \"Suburb\"     : \"Rockdale\",\r\n" + 
				"    \"City\"       : \"Sydney\"\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"  \"salary\"  :10.5 ,\r\n" + 
				"  \"married\" : true,\r\n" + 
				"  \"town\" : \"Kogarah\",\r\n" + 
				"  \"City\"  : \"Adelaide\"\r\n" + 
				"}\r\n" + 
				"   ]\r\n" + 
				"}\r\n" + 
				"  ]" ;
		
		JsonPath jsonpath = new JsonPath(jsonArray);
		//Fetching the first Json array inside the aaddress -1st  nested json value 
		String city1 = jsonpath.getString("[0].address[0].City");
		//Fetching the first Json array inside the aaddress -2nd  nested json value 
		String town1 = jsonpath.getString("[0].address[1].town") ;
		
		int age = jsonpath.getInt("[0].age");
		String fname = jsonpath.getString("[0].firstname");
		
		//Fetching the second Json array inside the aaddress -1st  nested json value 
		String city2 = jsonpath.getString("[1].address[0].City");
       //Fetching the second Json array inside the aaddress -1st  nested json value 
		String town2 = jsonpath.getString("[1].address[1].town") ;
		
		int age2 = jsonpath.getInt("[1].age");
		String fname2 = jsonpath.getString("[1].firstname");
		
		System.out.println ("first json array value :" + city1 + " " + town1 + " " + age + " " + fname + 
			" " + "second json array value :" + city2 + " " + town2 + " " + age2 + " " + fname2);
		
		//Get the list of all the array values - suppose under parent address we wanted the list of the cities 
	    List<Object> allCities = jsonpath.getList("[0].address.City");
		 System.out.println ("List of cities :" + allCities);
		 
		//Get the list of all the array values - for all the city values 
		 List<Object> allCity = jsonpath.getList("address.City");
		 System.out.println ("List of all  cities :" + allCity); 
  }

}

//Output
//first json array value :Sydney Kogarah 32 Jiten second json array value :Sydney Kogarah 26 Priya
//List of cities :[Sydney, Melbourne]
//List of all  cities :[[Sydney, Melbourne], [Sydney, Adelaide]]