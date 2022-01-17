package poJOExamples;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

@JsonIncludeProperties(value = {"firstname" , "skills"}) //specify the values to pass 
public class POJO_Class_Creation_02 extends POJO_Class_Creation {
	
	//generate the Getters and Setters 
	
	private String skills ;
    
	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	
	
	

	
}
