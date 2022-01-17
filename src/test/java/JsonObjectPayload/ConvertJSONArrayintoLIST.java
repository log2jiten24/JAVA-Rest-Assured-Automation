package JsonObjectPayload;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertJSONArrayintoLIST {

	public static void main(String[] args) {

        List<Map<String , Object>> allDetails = 
		                        RestAssured.
		                                      //give the mock URL which will have the response recorded
		                                     get("https://run.mocky.io/v3/3f813fa0-e6f5-499f-8c01-2f10d53177ae")
		                                     //.as(List.class);
		                                     //using typeRef - to pass generic data type 
		                                     .as(new TypeRef<List<Map<String ,Object>>>() {});
        
		System.out.println ("Array List size :-" + allDetails.size()) ;
		//getting the first index of the list and storing the JSON Object inside the Map
		Map<String, Object> mapDetails  =  (Map<String, Object>) allDetails.get(0) ;
		
		System.out.println ("each key retreival :" + mapDetails.get("email"));
		
		//get the List value and stored inside the Map - as the first Index is going to have JSON Object
		Map<String , Object> all_Map = allDetails.get(0);
		System.out.println ("Each Key details :" + all_Map.get("first_name"));
		

	}

}
