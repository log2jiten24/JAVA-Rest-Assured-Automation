package datashare;

import java.util.LinkedHashMap;

public class DataStoreAsMap {
	
	
	//Create Linked HashMap and store and retrieve the values inside the Map 
	
	private DataStoreAsMap () {
		
	}
	
	private static LinkedHashMap<String , Object> dataMap = new LinkedHashMap<String , Object> ();
	
	public static void  setValue (String key , Object value ) 
	{
		
		dataMap.put(key, value) ;
	}
	
	public static Object getValue (String key) 
	{
		return dataMap.get(key);
		
	}
	

}
