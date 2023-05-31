package restAPIExamples;




import org.eclipse.jetty.client.api.Request;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerToken_Examples {


	public static void main (String [] args ) {
		
		RestAssured.baseURI = "https://bookstore.demoqa.com" ;
		
		RequestSpecification requestSpec = RestAssured.given() ;
		
		String payload = "{\r\n" + 
				"\"userName\" : \"TOOLSQA-Test\",\r\n" + 
				"\"password\" : \"Test@@123\"\r\n" + 
				"\r\n" + 
				"}";
		
		requestSpec.header("Content-Type" , "application/json") ;
		
		//pass the payload as request body to generate the token and get as Response Object
		Response responsefromGenerateToken = requestSpec.body(payload).post("/Account/v1/GenerateToken");
		//get the response and print the response in the pretty format 
		responsefromGenerateToken.prettyPrint();
		
		//to extract the bearer token from the response first convert the JSON Response to the String
		
		String jsonResp = responsefromGenerateToken.getBody().asString();     
		//to extract the token from the response 
		String json_token = JsonPath.from(jsonResp).get("token");
		
		//System.out.println ("JSON token  value :" + json_token);
		
		//Pass the Token inside the Header for another request
		
		requestSpec.header("Authorisation" , "Bearer " + json_token)
		           .header("Content-Type", "application/json");
		
		String new_request = "{\r\n" + 
				"\"userId\": \"a178a104-e3c0-4f50-bbd5-3e4919f063e8\",\r\n" + 
				"\"collectionOfIsbns\" : [\r\n" + 
				"{\r\n" + 
				"    \"isbn\" : \"9781449325862\"\r\n" + 
				"}\r\n" + 
				"  ]\r\n" + 
				"     }";
		
		//post the request and get the response 
	Response addBooksResponse 	= requestSpec.body(new_request).post("/BookStore/v1/Books")	;

	//Add the Assertions - to get the Status code 
    Assert.assertEquals(201, addBooksResponse.getStatusCode());
	
				
		
		
		
		
	}

}
