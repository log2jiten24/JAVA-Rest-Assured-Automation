package advancedAPIConcepts_Utilities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "employees")
public class XML_Getters_Setters {

   @JacksonXmlElementWrapper(localName = "employee", useWrapping = false)
   private POJO_XML_Class[] employee ;

    public POJO_XML_Class[] getEmployee (){
        return  employee ;
    }

    public void setEmployee (POJO_XML_Class[] employee) {
        this.employee = employee ;
    }

    public String toString () {
        return "Class POJO [employee = " + employee + "]" ;

    }
}
