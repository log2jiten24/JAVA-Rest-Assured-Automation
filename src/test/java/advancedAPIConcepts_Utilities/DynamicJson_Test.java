package advancedAPIConcepts_Utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DynamicJson_Test {


    public static DynamicJSON_01 dynamicjsonproduct (String jsonpath , ObjectMapper objMapper ) throws IOException {

        //read the JSON file
        DynamicJSON_01 dynamicnode =  objMapper.readValue(new File(jsonpath) , DynamicJSON_01.class) ;
        //return the object of the class
        return dynamicnode ;
    }


    public static void main(String[] args) throws IOException {

        ObjectMapper objMap = new ObjectMapper() ;
        //First set of Json FIle
        String dynamicjson_01  = "./JsonPractice/DynamicJson_01.json" ;
        //Create the object of the Json POJO Clas
        DynamicJSON_01 obj1 = dynamicjsonproduct(dynamicjson_01 , objMap) ;

        System.out.println (obj1.getName()) ;
        System.out.println (obj1.getCategory()) ;
        System.out.println (obj1.getDetails().get("size").asText() ) ;

        System.out.println (obj1.getDetails().get("color")) ;
        System.out.println (obj1.getDetails().get("material")) ;
        System.out.println ("*************************************************************");

        //Second  set of Json FIle
        String dynamicjson_02  = "./JsonPractice/DynamicJson_02.json" ;
        //Create the object of the Json POJO Clas
        DynamicJSON_01 obj2 = dynamicjsonproduct(dynamicjson_02 , objMap) ;

        System.out.println (obj2.getName()) ;
        System.out.println (obj2.getCategory()) ;
        System.out.println (obj2.getDetails().get("audioConnector").asText()) ;
        System.out.println (obj2.getDetails().get("displayRatio").asText()) ;
        System.out.println ("*************************************************************");
    }
}
