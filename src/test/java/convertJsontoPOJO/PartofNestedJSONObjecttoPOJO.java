package convertJsontoPOJO;

import io.restassured.RestAssured;

public class PartofNestedJSONObjecttoPOJO {

	public static void main(String[] args) {
		
		//Convert a part of JSON Response to POJO
		
		Address_POJO_Class addressObj = 	
                RestAssured
                               //pass the GET URL 
                               .get("https://run.mocky.io/v3/02818b7c-58de-4c69-a0ea-b322a3b5138e")
                               //For the GetObject - pass the path for which tag response which we wanted to extract and in another parameter 
                               //give the path of the POJO Class 
                               .jsonPath().getObject("address", Address_POJO_Class.class);

       //to retrieve the values from the POJO - once the JSON Object is converted to the POJO Class 

          System.out.println ("Address tag Information :" + addressObj.getStreetName() + "-" + addressObj.getCity()
              +"-" + addressObj.getFlatNum() + "-" + addressObj.getState() + "-" + addressObj.getPostCode());




	}

}
