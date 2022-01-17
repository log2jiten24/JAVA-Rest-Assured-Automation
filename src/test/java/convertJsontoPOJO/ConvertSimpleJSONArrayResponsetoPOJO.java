package convertJsontoPOJO;

import io.restassured.RestAssured;

public class ConvertSimpleJSONArrayResponsetoPOJO {

	public static void main(String[] args) {

      //Convert JSON Array Response to the POJO Class
		Address_POJO_02[] addressObj = 	
                RestAssured
                               //pass the GET URL 
                               .get("https://run.mocky.io/v3/02818b7c-58de-4c69-a0ea-b322a3b5138e")
                               //Use class Name as Array where all the Address POJO class details is saved 
                               .as(Address_POJO_02[].class);
		//Array size length print it 
		System.out.println ("Size of Array :" + addressObj.length);

		System.out.println ("1st Array Retreival :" + addressObj[0].getCity() + " " + addressObj[0].getState() + " " 
				+ addressObj[0].getFlatNum() + " " + addressObj[0].getPostcode() + " " +
				addressObj[0].getStreetName());
		
		System.out.println ("2nd Array Retreival :" + addressObj[1].getCity() + " " + addressObj[1].getState() + " " 
				+ addressObj[1].getFlatNum() + " " + addressObj[1].getPostcode() + " " +
				addressObj[1].getStreetName());
	}

}
