package advancedAPIConcepts_Utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class ReadJsonfromURL_02 {

  /*
   * JSON File - > URI - > URL - > JsonNode
   * @author : Kumar Jitendra
   */

public static void jsonFileReadURL ( String jsonKeyValue , String keyValue) throws IOException {

    File file = new File("./JsonPractice/PracticeSample.json");
    System.out.println ("Path :" + file.getPath());

    //Convert File -> URI
    URI uri = file.toURI();
    System.out.println ("Path :" + uri.toString());

    //Convert URI - > URL
    URL url = uri.toURL();
    System.out.println ("URL :" + url.toString());
    //Convert URL to JSONNode
    ObjectMapper objmapper = new ObjectMapper() ;
    JsonNode jsonnode = objmapper.readValue(url , JsonNode.class) ;
    JsonNode nodeobj = jsonnode.get(jsonKeyValue) ;
    String jsonvalues = nodeobj.get(keyValue).asText();
    System.out.println ("Json values are : " + jsonvalues);

}


    public static void main(String[] args) throws IOException {

    String jsonFile = "./JsonPractice/PracticeSample.json" ;
    //Convert Json File - > URI - > URL  -> then convert to JSONNode - > to read the JSON values
    jsonFileReadURL("Bob" , "firstname");


    }
}
