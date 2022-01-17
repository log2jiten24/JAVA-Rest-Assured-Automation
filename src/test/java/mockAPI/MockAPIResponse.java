package mockAPI;

import io.restassured.RestAssured;

public class MockAPIResponse {

	public static void main(String[] args) {
		
		
		//Mock the API Data with real Mock Response 
		
		RestAssured.
                     given()
                            .log()
                            .all()
                            //give the Mock URL where we want to Mock the API URL  Response -end point url 
                            .get("https://run.mocky.io/v3/6f0bb138-cf54-47bb-88c4-f61d5f26f7dd")
                    .then()
                             .log()
                             .all();
                             
		
		        
		
		


	}

}
