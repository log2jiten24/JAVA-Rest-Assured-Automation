package restAPIExamples;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MeasureResponseTime {

	@Test
	public void mesaureResponseTime() {
		
		Response response = 
				
				RestAssured.given()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking")
				.body("{\r\n" + "    \"firstname\" : \"Jitennnnn007\",\r\n" + "    \"lastname\" : \"Brewown055501\",\r\n"
						+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
				.contentType(ContentType.JSON).when()
				// Hit the request
				.post();
		        //print the response in JSON format 
		        response.then().extract().asPrettyString();
		        
		        System.out.println ("Response body :" + response.then().extract().asPrettyString());
				
		        //get the Response time -- it will return the response time in long seconds 
		        long Responsetime = response.time();
		        System.out.println("Response Time  :" + Responsetime);
		       
		        //get the Response time in seconds 
		        long ResponseTimeInSeconds =   response.timeIn(TimeUnit.SECONDS);
		        System.out.println ("Response time In Seconds :" + ResponseTimeInSeconds);

		        //alternate way of doing it using the getTime - method
		        long Responsetime01 = response.getTime();
		        System.out.println("Response Time using Get time in MS   :" + Responsetime01);
		       
		        //get the Response time in seconds 
		        long ResponseTimeInSeconds02 =   response.getTimeIn(TimeUnit.SECONDS);
		        System.out.println ("Response time In Seconds using Get time :" + ResponseTimeInSeconds02);
		      
		        //another way using the time assertion with then method 
		      
		        response.then().time(Matchers.lessThan(5000L));
		        
		        //to check my response time is greater than 2 seconds or not 
		        response.then().time(Matchers.greaterThan(2000L));
		        
		        //calling assetions time between 2 Seonds and less than 5 seconds - adding both the conditions 
		        response.then()
		        .time(Matchers.both(Matchers.greaterThan(2000L))
		        .and(Matchers.lessThan(5000L)));
		      
		        //adding another assertion method - verifying the assertion response in 2 Seconds 
		        response.then().time(Matchers.lessThan(5L), TimeUnit.SECONDS);
		      
	}
}
