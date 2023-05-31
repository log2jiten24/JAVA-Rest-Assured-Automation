package advancedAPIConcepts_Utilities;

public class Serialisation_NestedJson_UserAddress {

    String name ;
    int age ;
    String email ;
    boolean isDeveloper ;
    Serialisation_User_Address user_address ;

    //create the constructor of the pass and pass the initial values
    public Serialisation_NestedJson_UserAddress(String name , String email , boolean isDeveloper , int age , Serialisation_User_Address
                                       user_address) {
        super();
        this.name = name ;
        this.email = email ;
        this.isDeveloper = isDeveloper ;
        this.age = age ;
        this.user_address = user_address ;
    }
}
