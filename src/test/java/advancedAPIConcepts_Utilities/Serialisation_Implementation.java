package advancedAPIConcepts_Utilities;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class Serialisation_Implementation
{


    public static void main(String[] args) {

        //Initialise the Java Object for which we want to create the JSON
        Serialisation_User_Address useraddress = new Serialisation_User_Address("Unit 87" , "2B" ,
                "Sydney" , "Australia") ;
        Serialisation_NestedJson_UserAddress userNestedJson = new Serialisation_NestedJson_UserAddress("Jitendra" ,
                "log2jeet24@gmail.com" , true , 34 , useraddress);

        //Create the Object of the Gson Library which we can use to convert the Java Object to the Json
        Gson gson = new Gson() ;
        //Give the object of the NestedJson which we want to convert the Java Object to String Json
        String json_obj = gson.toJson(userNestedJson) ;
        System.out.println ("Json String conversion :" + json_obj) ;

        //lets write the json to another file
        String write_output_file = "./JsonPractice/SerialisedJSON_Object.json" ;
        FileWriter fw = null ;

        try {
            fw = new FileWriter(write_output_file);
            gson.toJson(userNestedJson, fw);
            //close the file
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println ("File created successfully ") ;

    }

}
