package advancedAPIConcepts_Utilities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class POJO_XML_Class {

    //id is not an a xml attribute
    @JacksonXmlProperty (localName = "id" , isAttribute = true)
    private String id ;
    @JacksonXmlProperty (localName = "firstName")
    private String firstName ;
    @JacksonXmlProperty (localName = "lastName")
    private String lastName ;
    @JacksonXmlProperty (localName = "age")
    private int age ;

    //create a default constructor
    public POJO_XML_Class (){

    }

    //Create Constructor with passing parameters
    public POJO_XML_Class (String id , String firstName , String lastName , int age ) {

        this.id = id ;
        this.firstName = firstName ;
        this.lastName = lastName ;
        this.age = age ;
    }
}
