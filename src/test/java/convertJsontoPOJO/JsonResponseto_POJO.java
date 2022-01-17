package convertJsontoPOJO;

import io.restassured.RestAssured;

public class JsonResponseto_POJO {

	public static void main(String[] args) {
		
	Create_POJO_Class_01 objResp = 	
		                            RestAssured
		                                           //pass the GET URL 
		                                           .get("https://run.mocky.io/v3/11c56662-a485-42ef-ab30-78acb11eff37")
		                                           //Pass the POJO Class Name as Return type to convert the JSON Object to the POJO Class
		                                            .as(Create_POJO_Class_01.class);
	
	//to retrieve the values from the POJO - once the JSON Object is converted to the POJO Class 
	
	System.out.println ("Retrieval of ID :" + objResp.getFirstname() + "- " + objResp.getLastname() + " "
			+ "-" + objResp.getAge() + "-" + objResp.getGender() + "-" + objResp.getSalary());
	
	

	}

}
