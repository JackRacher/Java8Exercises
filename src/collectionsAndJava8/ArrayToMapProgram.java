package collectionsAndJava8;

import java.util.HashMap;
import java.util.Map;

class ArrayToMap{
	public static Map<Integer, String> arrayToMap(String[] array){
		if(array == null)
			return null;
		
		Map<Integer, String> stringMap = new HashMap<Integer, String>();
		for (int i = 0; i < array.length; i++) {
			
			stringMap.put((i + 1), array[i]);
		}
		return stringMap;
	}
}
public class ArrayToMapProgram {

	public static void main(String[] args) {
		String[] array = {"Ram", "Sam", "Jam", "Tom"};
		
		System.out.println(ArrayToMap.arrayToMap(array));
	}
}
