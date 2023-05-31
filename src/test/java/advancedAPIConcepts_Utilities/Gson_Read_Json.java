package advancedAPIConcepts_Utilities;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.avro.data.Json;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Gson_Read_Json {

  /*
  This method converts the JSon File to the Json Object and it returns the JsonObject
   */

    public static JsonObject getJsonObjectFromJson (String path , Gson gson) {

        Reader reader = null ;
        try {
            reader = new FileReader(path) ;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //Json Element
        JsonElement jsonElement = gson.fromJson(reader , JsonElement.class) ;
        //Json Element -> String
        String jsonString = gson.toJson(jsonElement) ;
        //JsonElement - > Json Object
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        return jsonObject ;

    }

    /*
    Fetch the Json Elements from the Json
     */

    public static void fetchDatafromJson (JsonObject jsonObject , Gson gson, String key ) {

        String value = jsonObject.get(key).getAsString() ;
        System.out.println ("Json Value retrieved : " + value) ;
    }

    /*
    Fetch the Json Elements from the Json
     */

    public static void fetchDatafromJsonArray ( JsonObject jsonObject , Gson gson , String arraykey ) {

        JsonArray arraylist = jsonObject.getAsJsonArray(arraykey);
        //pass the array list
        List<String> list = gson.fromJson(arraylist , ArrayList.class) ;
        System.out.println ("Values inside the ArrayList :" + list) ;


    }

    public static void main(String[] args) {
       //Create the object of the Gson class
        Gson gson = new Gson () ;
        String path = "./JsonPractice/gson_sample.json" ;
        //fetch the Json as Object - pass the String path and
        JsonObject jsonObject1 = getJsonObjectFromJson(path , gson) ;
        //pass the Json Object , Gson Object and the Json String key value to fetch the values
        fetchDatafromJson(jsonObject1 , gson , "ID" );
        //pass the Json Object , Gson Object and the Json String key array value to fetch the values
        fetchDatafromJsonArray(jsonObject1 , gson , "Skills");
    }
}
