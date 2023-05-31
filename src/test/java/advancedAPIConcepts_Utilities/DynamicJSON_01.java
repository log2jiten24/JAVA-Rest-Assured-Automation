package advancedAPIConcepts_Utilities;

import com.fasterxml.jackson.databind.JsonNode;

public class DynamicJSON_01 {

    //Create the POJO of the Dynamic JSON Object

    String name ;
    String category ;
    //Create the Dynamic part of the JSON Object which is always changing
    JsonNode details ;

    public String getName () {
        return name ;
    }

    public void setName (String name) {
        this.name = name ;
    }

    public String getCategory () {
        return category ;
    }

    public void setCategory  (String category) {
        this.category = category ;
    }

    public JsonNode getDetails()  {
        return details ;
    }

    public void setDetails (JsonNode details) {
        this.details = details ;
    }

}
