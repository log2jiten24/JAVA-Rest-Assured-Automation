package convertJsontoPOJO;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class NestedJSONObjectTOPOJO {

	public static void main(String[] args) {
		
//		ObjectMapper objectMapper = new ObjectMapper();
//	    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

       //give the parent class name where all the object values is stored 
		Create_POJO_Class_02 objResp1 = 	
                RestAssured
                               //pass the GET URL 
                               .get("https://run.mocky.io/v3/c2784e11-50a9-4a8f-9411-4a51abc6c7bd")
                               //Pass the POJO Class Name as Return type to convert the JSON Object to the POJO Class
                                .as(Create_POJO_Class_02.class);

//to retrieve the values from the POJO - once the JSON Object is converted to the POJO Class 

System.out.println ("Retrieval of ID :" + objResp1.getFirstname() + "-" + objResp1.getLastname() + " "
		+ "-" + objResp1.getAge() + "-" + objResp1.getGender() + "-" + objResp1.getSalary() + "Address Retrieval " +
		objResp1.getAddress().getFlatNum() + "-" + objResp1.getAddress().getCity() + "-"  + 
		objResp1.getAddress().getPostCode());




	}

}
