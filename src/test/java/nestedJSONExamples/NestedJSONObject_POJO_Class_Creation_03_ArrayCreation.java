package nestedJSONExamples;

import java.util.List;

public class NestedJSONObject_POJO_Class_Creation_03_ArrayCreation {

	private String firstname;
	private String lastname;

	private String gender;

	// create the List
	private List<NestedJSONObject_POJO_Class_Creation_02> addresses;

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

	// generated the Getters and Setters for the List type

	public List<NestedJSONObject_POJO_Class_Creation_02> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<NestedJSONObject_POJO_Class_Creation_02> addresses) {
		this.addresses = addresses;
	}

}
