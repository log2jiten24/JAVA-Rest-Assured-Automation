package convertJsontoPOJO;

public class Employee_POJO_Class {

    private String Name ;
    private String Surname ;
    private String Age ;
    private Address_POJO_Class_Update_03 addressobj ;
    private Office_POJO_Class office_pojo_obj ;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public Address_POJO_Class_Update_03 getAddressobj() {
        return addressobj;
    }

    public void setAddressobj(Address_POJO_Class_Update_03 addressobj) {
        this.addressobj = addressobj;
    }

    public Office_POJO_Class getOffice_pojo_obj() {
        return office_pojo_obj;
    }

    public void setOffice_pojo_obj(Office_POJO_Class office_pojo_obj) {
        this.office_pojo_obj = office_pojo_obj;
    }




}
