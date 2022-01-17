package jsonPathExamples;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class WithInlineAssertion {

	public static void main(String[] args) {
	
		
		 RestAssured
		           .given()
		                   .baseUri("https://restful-booker.herokuapp.com/auth")
		                   .log()
		                   .all()
		                   .body("{\r\n" + 
		                   		"    \"username\" : \"admin\",\r\n" + 
		                   		"    \"password\" : \"password123\"\r\n" + 
		                   		"}")
		                   .contentType(ContentType.JSON)
		            .when()
		                   .post()
		            .then()
		                  //verify the token value -with assertion from Matchers class - it is not null
		                   .body("token", Matchers.notNullValue())
		                   //verify the length is equal to 15 
		                   .body("token.length()", Matchers.is(15))
		                   //verify the length in another way 
		                   .body("token.length()", Matchers.equalTo(15))
		                   
		                   .log()
		                   .all();
		                   
	//another Get Response
		 RestAssured
         .given()
                 .baseUri("https://restful-booker.herokuapp.com/booking")
                 .log()
                 .all()
                 .contentType(ContentType.JSON)
          .when()
                 .get()
          .then()
                //verify the token value -with assertion from Matchers class - it is not null
                 .body("bookingid", Matchers.notNullValue())
                 //verify the length is equal to 15 
                 .body("bookingid", Matchers.hasItems(9,10))
            
                 .log()
                 .all();
		 
		 

	}

}
