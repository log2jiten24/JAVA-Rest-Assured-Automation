package methodChaininingConcepts;


class MethodRepo {
	//method chaining example - return the same method reference 
	public MethodRepo printName(String name) {
		System.out.println ("Print name is :" + name);
		//return the same object reference 
		return this ;
	}
	
	public MethodRepo printAge (int age) {
		System.out.println ("Age is :" + age) ;
		//return the same object reference
		return this;
	}
}

public class MethodChainingExample {

	public static void main(String[] args) {
		
		MethodRepo obj = new MethodRepo();
	   //usage of method chaining to call one method one after another 
	   obj.printAge(32).printName("Jiten");
	}

}
