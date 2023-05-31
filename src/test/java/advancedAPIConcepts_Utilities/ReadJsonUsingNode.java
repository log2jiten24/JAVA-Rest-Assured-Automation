package advancedAPIConcepts_Utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;

public class ReadJsonUsingNode {

    static ObjectMapper objMapper = new ObjectMapper() ;

    /*
    Method : To read the Json based on the Json Node - pass the  base Node of the Json and the Json Key Value .
    Parameters : JsonNode - path of the Json , Base Node Value ,  which key value the values which we want to fetch
    Authors : Kumar Jitendra
     */
    public static void readJsonNodeSimple (JsonNode jsonNode , String baseNodeName, String keyValue) {

        System.out.println ("-------------------****************-----------------") ;
        JsonNode nodefirst = jsonNode.get(baseNodeName) ;

        String firstValue = nodefirst.get(keyValue).asText();
        System.out.println ("Json values :" + firstValue);
        System.out.println ("-------------------****************-----------------") ;

    }

    /*
   Method : To read the Json based on the Json Node - pass the  base Node of the Json and the Json Key Value .
   Parameters : JsonNode - path of the Json , Base Node Value , Nested Json Key  key value the values which we want to fetch
   Authors : Kumar Jitendra
    */
    public static void readNestedJsonNode (JsonNode jsonNode , String baseNodeName, String keyValue1, String keyValue2) {

        System.out.println ("-------------------****************-----------------") ;
        JsonNode nodefirst = jsonNode.get(baseNodeName) ;
        JsonNode nodeSecond = nodefirst.get(keyValue1) ;
        String nestedJsonValue = nodeSecond.get(keyValue2).asText();
        System.out.println ("Nested Json values :" + nestedJsonValue);
        System.out.println ("-------------------****************-----------------") ;

    }

    /*
  Method : To read the Json based on the Json Node - pass the  base Node of the Json and the Json Key Value .
  Parameters : JsonNode - path of the Json , Base Node Value , Nested Json Key  key value the values which we want to fetch
  Authors : Kumar Jitendra
   */
    public static void readJsonArray (JsonNode jsonNode , String baseNodeName, String arrayNode) {

        System.out.println ("-------------------****************-----------------") ;
        JsonNode nodefirst = jsonNode.get(baseNodeName) ;
        JsonNode nodeSecond = nodefirst.get(arrayNode) ;
        //get the second value inside the Json Array
        String nestedJsonValue = nodeSecond.get(2).asText();
        System.out.println ("Json Array Value  :" + nestedJsonValue);
        System.out.println ("-------------------****************-----------------") ;
        //get all the Json Array values
        ArrayNode arraySkillsNode = (ArrayNode) nodefirst.get(arrayNode) ;
        if (arraySkillsNode.isArray()) {
            System.out.println ("Converted to JsonArray");
            for (JsonNode node : arraySkillsNode) {
                String arrayValue = node.asText() ;
                System.out.println ("All the array values :" + arrayValue) ;
            }
            System.out.println ("-------------------****************-----------------") ;


        }


    }



    public static void main (String[] args) throws IOException {


        String jsonFile = "./JsonPractice/PracticeSample.json" ;

        JsonNode jsonNode = objMapper.readTree(new File(jsonFile)) ;

        //reading the simple first json - key and value pair
        readJsonNodeSimple(jsonNode, "Bob", "firstname");
        //reading the nested  json - key and value pair
        readNestedJsonNode(jsonNode, "Bob", "address", "Street");
       //reading the json array inside the json
        readJsonArray(jsonNode, "Bob" , "skills");

        //reading the simple second json - key and value pair
        readJsonNodeSimple(jsonNode, "Fed", "firstName");
        //reading the nested second json - key and value pair
        readNestedJsonNode(jsonNode, "Fed", "address", "Street");

    }
}
