package datashare;

public class ThreadLocalExample {

	public static void main(String[] args) {
		
		//create object of the ThreadLocal class 
		ThreadLocal tlocal = new ThreadLocal () ;
		
		//set the name inside the Threadlocal object
		
	    tlocal.set("Jiten");
	    
	    //get the value from the tlocal
	    String name = (String) tlocal.get() ;
	    
		System.out.println ("Thread local stored :" + name) ;
		
		//remove the value from the tlocal
		tlocal.remove();
		System.out.println ("Remove the value from the tlocal :" + ((String)tlocal.get()));
		
		//create the second tlocal object and store retrieve the tlocal value  
		ThreadLocal tlocal2 = ThreadLocal.withInitial(() ->"Jitendra" );
		System.out.println ((String) tlocal2.get());
		
		
		//user Generics for  ThreadLcoal - to pass any String as generics 
		ThreadLocal<String> tlocal3 = new ThreadLocal<String> ();
		//now set the value 
		tlocal.set("JeetPriya");
		
		System.out.println ("Get the value : " + tlocal.get()) ;
		
		
		
		
		
		
		

	}

}
