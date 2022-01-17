package convertJsontoPOJO;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertSimpleJSONArrayResponsetoPOJO_02 {

	public static void main(String[] args) {
		
		
		 //Convert JSON Array Response to the POJO Class
		List<Address_POJO_02> addressObj = 	
                RestAssured
                               //pass the GET URL 
                               .get("https://run.mocky.io/v3/02818b7c-58de-4c69-a0ea-b322a3b5138e")
                              //TypeRef is an abstract class and we are using Anonymous Inner class 
                               .as(new TypeRef<List<Address_POJO_02>>() {});
							
		
		//List  size  print it 
		System.out.println ("Size of Array :" + addressObj.size());

		System.out.println ("1st Array Retreival :" + addressObj.get(0).getCity() + " " + addressObj.get(0).getState() + 
				" " + addressObj.get(0).getFlatNum() + " " + addressObj.get(0).getStreetName() + " " + addressObj.get(0).getStreetName()
				+" " + addressObj.get(0).getPostcode() );
		
		System.out.println ("2nd Array Retreival :" + addressObj.get(1).getCity() + " " + addressObj.get(1).getState() + 
				" " + addressObj.get(1).getFlatNum() + " " + addressObj.get(1).getStreetName() + " " + addressObj.get(1).getStreetName()
				+" " + addressObj.get(1).getPostcode() );
	}

}
