package advancedAPIConcepts_Utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadJsonfromURL {


    public static void readJSONFromWebURL (String URLName , String keyName ) throws MalformedURLException , IOException {

        //load the URL
        URL url = new URL (URLName) ;
        //Create the Object of the Object Mapper class present inside the Jackson Library
        ObjectMapper objectmapper  = new ObjectMapper ();
        //read the JSON from the webURL by using the JSON Node
        JsonNode jsonnode = objectmapper.readValue(url , JsonNode.class) ;
        System.out.println ("*************************");

        System.out.println ("Json value retrieved :" + jsonnode.get(keyName).asText()) ;
        //Write the JSON Path to retrieve the values
        System.out.println ("Character values :" + jsonnode.path("character").path("name").asText());
        System.out.println ("Character values :" + jsonnode.path("character").path("house").path("name").asText());
        System.out.println ("*************************");
    }


    public static void main (String [] args ) throws IOException {

        String URLName = "https://api.gameofthronesquotes.xyz/v1/random";
        readJSONFromWebURL(URLName , "sentence") ;
    }
}
