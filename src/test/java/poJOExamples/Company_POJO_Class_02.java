package poJOExamples;

public class Company_POJO_Class_02 {

	public static void main(String[] args) {
		
		
		Employee_POJO_2 obj = new Employee_POJO_2 () ;
		
		obj.setId(201);
		obj.setDeptId(24022);
		obj.setGender("male");
		obj.setName("Jitendra");
		obj.setMobNum("0405009374");
		
        Employee_POJO_2 obj1 = new Employee_POJO_2 () ;
		
		obj1.setId(2000);
		obj1.setDeptId(24096);
		obj1.setGender("female");
		obj1.setName("Priya");
		obj1.setMobNum("0423459641");
		
		System.out.println ("Retrive first object id and name" + " -" + obj.getId() + " " + " name " + "-" + obj.getName());
		
		System.out.println ("Retrive second object id and name" + " -" + obj1.getId() + " " + " name " + "-" + obj1.getName());
		
		
		
		
		

	}

}
