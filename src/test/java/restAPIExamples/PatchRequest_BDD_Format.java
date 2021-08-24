package restAPIExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PatchRequest_BDD_Format {

	public static void main(String[] args) {
		
		RestAssured.
                    given()
                           .log()
                           .all()
                           .baseUri("https://restful-booker.herokuapp.com/")
                            //passing  the parameters 
                           .basePath("{basePath}/{bookingId}")
                           .pathParam("basePath", "booking")
                           .pathParam("bookingId", 10)
                           .contentType(ContentType.JSON)
                           //pass the headers value inside the request 
                           .header("Content-type" , "application/json")
                           .headers("Authorization" , "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                           .body("{\r\n" + 
               		         "    \"firstname\" : \"Said\",\r\n" + 
               		         "    \"lastname\" : \"Abbasss\"\r\n" + 
               		         "}")
                    .when()
                          //hit the request 
                            .patch()
                          //Validate the response 
                    .then()
                          .log()
                          .all()
                          .assertThat()
                          .statusCode(200);


	}

}
