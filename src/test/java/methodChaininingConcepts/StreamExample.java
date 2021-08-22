package methodChaininingConcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
	
	
	public static void main(String[] args) {
		
	//create an array of list 
		
	List <String> alllist = Arrays.asList("Apples" , "Oranges" , "Mangoes"  , "Guava");
		
	//Output we want 
	//Fruit Apples Fruit Oranges Fruit Mangoes Fruit Guava
	
	//we can do the same thing through stream API 
	Stream<String> names = alllist.stream();
	//add any content which needs to be appended inside the list
	Stream<String> newMap = names.map(anything -> anything + "Fruits");
	//store the new Names inside the new List 
	List<String > newNames = newMap.collect(Collectors.toList());
	System.out.println ("all new names :" + newNames);
	
	//Method Chaining - calling multiple methods inside a single call(alternative way )
	List<String> all_names = alllist.stream().map(anything -> anything + "- Fruits ").collect(Collectors.toList());
	System.out.println ("updated names list :" + all_names);
	
	//Create one empty array list 
	//List<String> newnmames = new ArrayList<String>();
	
//	for (String allnames : alllist) {
//		
//		String newname = "fruit" + "-" +  allnames ;
//		//add the newname to the blank arraylist
//	    newnmames.add(newname);
//	}
//		System.out.println ("-----Before adding :" + alllist) ;
//		System.out.println ("-----After Adding :" + newnmames);
	
	//now do the same thing with the help of stream api 
	
	
   }

}
