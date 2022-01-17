package poJOExamples;

public class Company_POJO_Class {
	
	public static void main (String [] args) {
	
	Employee_POJO_Class obj = new Employee_POJO_Class() ;
	
	obj.id = 20 ;
	obj.name = "Kumar" ;
	obj.mobNum = "8879551929" ;
	obj.gender = "male" ;
	obj.depId = 240 ;
	obj.address = "Ashton Street SYDNEY" ;
	
   Employee_POJO_Class obj1 = new Employee_POJO_Class() ;
	
   obj1.id = 201 ;
   obj1.name = "Jiten" ;
   obj1.mobNum = "405009374" ;
   obj1.gender = "male" ;
   obj.depId = 2409 ;
   obj.address = "Green Street SYDNEY" ;
   
   System.out.println ("First Object value :" + obj.id);
   
   System.out.println ("Second Object value :" + obj1.name);
	
	
	}
}
