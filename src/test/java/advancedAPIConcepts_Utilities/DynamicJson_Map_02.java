package advancedAPIConcepts_Utilities;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.LinkedHashMap;
import java.util.Map;

public class DynamicJson_Map_02 {



    //Create the POJO of the Dynamic JSON Object

    String name ;
    String category ;
    //Create the Map for storing the dynamic values inside the Map
    Map<String , Object> details = new LinkedHashMap<String , Object >();

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

    public Map<String, Object>   getDetails()  {
        return details ;
    }

    public void setDetails (Map<String, Object> details) {
        this.details = details ;
    }

}


