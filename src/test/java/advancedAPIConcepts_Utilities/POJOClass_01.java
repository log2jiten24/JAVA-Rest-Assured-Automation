package advancedAPIConcepts_Utilities;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*
 # https://www.jsonschema2pojo.org/ - this is the site to convert the JSON to POJO Classes for each of the JSON Key
 */

public class POJOClass_01 {


    private String firstname;

    private String lastname;

    private Boolean isAlive;

    private Integer age;

    POJOClass_Address address;

    private List<POJOClass_PhoneNumbers> phoneNumbers;



    public String getFirstname() {
        return firstname;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getLastname() {
        return lastname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public Boolean getIsAlive() {
        return isAlive;
    }


    public void setIsAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }


    public Integer getAge() {
        return age;
    }


    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty("address")
    public POJOClass_Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(POJOClass_Address address) {
        this.address = address;
    }

    @JsonProperty("phoneNumbers")
    public List<POJOClass_PhoneNumbers> getPhoneNumbers() {
        return phoneNumbers;
    }

    @JsonProperty("phoneNumbers")
    public void setPhoneNumbers(List<POJOClass_PhoneNumbers> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }



}
