package jsonPathExamples;

import java.io.File;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class JsonPathwithFilters {

	public static void main(String[] args) {

		String filepath = System.getProperty("user.dir") + "\\JsonPractice\\sample.json";
		// Input the FileStream path
		File InputStream = new File(filepath);
		// pass the InputStream file under the JsonPath - constructor file path
		JsonPath jsonpath = new JsonPath(InputStream);

		// to fetch the first name from the first json and address
		System.out.println("First Json value name and address :" + jsonpath.getString("[0].firstname") + " "
				+ jsonpath.getString("[0].address.city"));

		// to get all the firstname from all the json values
		List<Object> fnames_all = jsonpath.getList("firstname");
		System.out.println("all names list :" + fnames_all);

		// usage of findAll - to refine or filter the search criteria -suppose for each
		// json we wanted to find the first name whose gender is female
		List<String> allFemaleFirstNames = jsonpath.getList("findAll{it.gender == 'female'}.firstname");
		System.out.println("allfemaleFirstNames :" + allFemaleFirstNames);

		// difference between findAll and find - findAll gives all the search criteria
		// Whereas find will go through specific json value when it finds
		// find will search for specific search criteria

		String emailld = jsonpath.getString("find{it.firstname == 'Aadya' & it.lastname == 'Singh'}.email");
		System.out.println("lastname specifc search" + " - " + emailld);
		
		//Using findAll with OR Search Criteria 
		List<String> allEmailID = jsonpath.getList("findAll{it.firstname == 'Khushi' | it.lastname == 'Singh'}.email");
		System.out.println("all Email Id  :" + allEmailID);
		
		//Using findAll with > greater than Sign 
		List<String> allfnames = jsonpath.getList("findAll{it.id >=2}.firstname");
		System.out.println("all firstnames :" + allfnames);
		
        //to get the size of the json values 
		System.out.println ("Json Array size - " +  " " + jsonpath.getInt("size()"));
		

	}

	//Output 
//	First Json value name and address :Kumar Sydney
//	all names list :[Kumar, Kumar01, Priyaa, Khushi, Aadya]
//	allfemaleFirstNames :[Priyaa, Khushi, Aadya]
//	lastname specifc search - log2aadya122@gmail.com
//	all Email Id  :[log2priya@gmail.com, log2priya122@gmail.com, log2aadya122@gmail.com]
//	all firstnames :[Kumar01, Priyaa, Khushi, Aadya]
//	Json Array size -  5
}
