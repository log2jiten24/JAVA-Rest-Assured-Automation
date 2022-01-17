package datashare;

import java.util.LinkedHashMap;

public class ThreadLocalDataStroeAsMap {

	// create the constructor
	private ThreadLocalDataStroeAsMap() {
	};

	// Create object of the THreadLocal class with Map as Generic -which will create
	// another LinkedHashMap

	private static ThreadLocal<LinkedHashMap<String, Object>> dataMap2 = ThreadLocal
			.withInitial(() -> new LinkedHashMap<String, Object>());


	public static void setValue(String key, Object value) {
		
        //first use the getMethod from threadlocal which will return the Map and it will store the information
		dataMap2.get().put(key, value);
	}

	public static Object getValue(String key) {
		//dataMap2.get() -it will return the Map - from where we can retrive the value 
		return dataMap2.get().get(key);

	}

}
