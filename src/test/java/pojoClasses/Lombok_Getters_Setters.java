package pojoClasses;

public class Lombok_Getters_Setters {

	public static void main(String[] args) {


		LombokJavaClasses lombokimplement = new LombokJavaClasses () ;
		
		lombokimplement.setName("Kumar Jitendra");
		//lombokimplement.setAge(32);
		lombokimplement.setMobNum("0405003974");
		lombokimplement.setDeptID(24031990);
		
		System.out.println ("Employee name: " + lombokimplement.getName() + " " + 
		
				  "MobileNumber :" + lombokimplement.getMobNum()  + " " + "DeptID: " + lombokimplement.getDeptID()) ;
		
	}

}
