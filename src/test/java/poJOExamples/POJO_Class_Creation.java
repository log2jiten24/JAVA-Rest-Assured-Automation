package poJOExamples;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import convertJsontoPOJO.Address_POJO_Class;


//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
//to exclude any empty list or map - we should see non empty 
//@JsonInclude(JsonInclude.Include.NON_EMPTY)--- to include the JSON values which are not empty 

@JsonIncludeProperties(value = {"firstname" , "lastname"})
public class POJO_Class_Creation {
	
	private String firstname;
	private String lastname;
	private String gender ;
	private int age ;
	private double salary ;
	private String country ;
	
	private List<String> skillSet ;
	private Map<String , Object> familyMembers ;
	
	
	//Generate the Getters and Setters 
	
	public List<String> getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(List<String> skillSet) {
		this.skillSet = skillSet;
	}
	public Map<String, Object> getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(Map<String, Object> familyMembers) {
		this.familyMembers = familyMembers;
	}
	
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	

}
