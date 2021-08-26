package restAPIExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Delete_Request_BDD_RestAssured {

	public static void main(String[] args) {
		
		//Passing the Delete Request 
		
		RestAssured.
		            given()
		                    .log()
		                    .all()
		                    .baseUri("https://restful-booker.herokuapp.com/")
		                    .basePath("{basePath}/{bookingId}")
		                    //passing Path Parameters 
                            .pathParam("basePath", "booking")
                            .pathParam("bookingId", 10)
                            .header("authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                            //passing the content type
                            .contentType(ContentType.JSON)
                           //hit the request
                    .when()
                            .delete()
                    .then()
                            .log()
                            .all()
                            .assertThat()
                            .statusCode(201);
                            
                            

	}

}
