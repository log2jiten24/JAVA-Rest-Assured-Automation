package jsonPathExamples;

import java.io.File;

import java.util.List;


import io.restassured.path.json.JsonPath;

public class JsonPathwithFilters_02 {

	public static void main(String[] args) {

		String filepath = System.getProperty("user.dir") + "\\JsonPractice\\Sample2.json";
		// Input the FileStream path
		File InputStream = new File(filepath);
		// pass the InputStream file under the JsonPath - constructor file path
		JsonPath jsonpath = new JsonPath(InputStream);
		
		// to fetch the first name from the first json and address
				System.out.println("First Json value name and address :" + jsonpath.getString("data[0].firstname") + " "
			+ jsonpath.getString("data[0].address.city") + " " + jsonpath.getString("data[1].email"));
				
		// json we wanted to find the first name whose gender is female
		List<String> allFemaleFirstNames = jsonpath.getList("data.findAll{it.gender == 'female'}.firstname");
		System.out.println("allfemaleFirstNames :" + allFemaleFirstNames);
		
		List<String> allAddress = jsonpath.getList("data.findAll{it.gender == 'male'}.address");
		System.out.println("All Addresses :" + allAddress);
		
		String  address =  jsonpath.getString("data.find{it.firstname == 'Kumar'}.address");
		System.out.println ("address list :" + address) ;
		
		String  city =  jsonpath.getString("data.find{it.firstname == 'Kumar'}.address.city");
		System.out.println ("city name :" + city) ;
		
		//Output 
//		First Json value name and address :Kumar Sydney log2jeet2400@gmail.com
//		allfemaleFirstNames :[Priyaa, Khushi, Aadya]
//		All Addresses :[{city=Sydney, town=Kogarah, suburb=Rockdale}, null]
//		address list :[city:Sydney, town:Kogarah, suburb:Rockdale]
//		city name :Sydney

		
	}

}
