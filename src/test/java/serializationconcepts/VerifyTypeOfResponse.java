package serializationconcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hamcrest.Matchers;
import io.restassured.RestAssured;

public class VerifyTypeOfResponse {

	public static void main(String[] args) {

		// In the mock URL - following Response has been given - {
//		"name" : Kumar Jitendra,
//		"dob"   : 24031990 ,
//		"listofSubjects" : ["Physics" ,"Chemistry" , "Maths"]
//		}

		RestAssured.get("https://run.mocky.io/v3/7afb99fe-c479-4d53-9a64-39b5837c569b")
		           .then()
				// to verify the response is of the array type - the response will have the JSON
				// Object and JSON Object
				// can be in the form of Map
				  .body("", Matchers.instanceOf(Map.class));
		
		//Array as Reponse in the form of -[
//		{
//			"name" : "Kumar Jitendra",
//			"age"  :  "33"
//			},
//			{
//			"name" : "Priya Singh",
//			"age"  : "28"
//			}
//
//			]
		
		RestAssured.get("https://run.mocky.io/v3/790624b8-fbf4-468c-a67b-a4b44746323c")
        .then()
		// to verify the response is of the array type - the response will have the JSON
		//Object value stored in the form of List 
		.body("", Matchers.instanceOf(List.class));


		List<String> all_list = new ArrayList<String> ();
		all_list.add("Kumar");
		all_list.add("Priya");
		
		String updated_name = all_list.stream().
				filter(e -> e.contentEquals("Priya")).findAny().get();
				//peek(e -> e.contentEquals("Priya")).findAny().get();
		
		System.out.println ("Updated name :" + updated_name.concat("Jeet")) ;
	}

}
