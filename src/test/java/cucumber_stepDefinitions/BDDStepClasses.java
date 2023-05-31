package cucumber_stepDefinitions;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matcher;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class BDDStepClasses {


    public static void simpleGETRequest(String postNumber) {

        given().contentType(ContentType.JSON);
        when().get(String.format("http://localhost:3000/posts/%s", postNumber))
                .then()
                .body("author" , is("typicode"));
    }

//    public static void performCollectionRequest() {
//
//        given().contentType(ContentType.JSON);
//        when()
//                .get("https://localhost:3000/posts/")
//                .then()
//                .body("author" , containsInAnyOrder("typicode" ));
//    }

    public static void performPathParameters (){

        given()
                        .contentType(ContentType.JSON)
                .with()
                       .pathParams("post",1)
                .when()
                       .get("http://localhost:3000/posts/{post}")
                .then()
                       .body("author" , containsString("typicode"));



    }



}