package advancedAPIConcepts_Utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Java_Deserialisation_Test_POJOClasses
{


@Test
public void testPOJOAttributes() throws IOException {

    String jsonFilePath = "./JsonPractice/PracticeSample_02.json" ;
    ObjectMapper objMapper = new ObjectMapper() ;
    POJOClass_01 pojovalues  = objMapper.readValue(new File(jsonFilePath) , POJOClass_01.class) ;

    pojovalues.getAddress().getCity();
    Assert.assertEquals(pojovalues.getAge().intValue(), 34 , "User Age is wrong") ;
    Assert.assertEquals(pojovalues.getFirstname(), "Kumar" , "User FirstName is wrong") ;

    assert  pojovalues.getPhoneNumbers().size() == 3 : "User has more or less phone Numbers ";

    System.out.println ("Assertion completed ") ;

}



}
