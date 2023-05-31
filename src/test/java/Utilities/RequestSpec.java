package Utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import lombok.var;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RequestSpec {

    public static RequestSpecification Request ;
    public RequestSpec() {
       //Arrange
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000");
        builder.setContentType(ContentType.JSON);

        RequestSpecification requestSpec = (RequestSpecification) builder.build();
        Request = RestAssured.given().spec(requestSpec);
    }

    //Act

    public static void GetOptionswithPathParameter (String url , Map<String , String> pathParams)  {

        Request.pathParams(pathParams);
        try {
            Request.get(new URI(url));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResponseOptions<Response> GetOps (String url)  {

        try {
            Request.get(new URI(url) );
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return  null ;
    }
}
