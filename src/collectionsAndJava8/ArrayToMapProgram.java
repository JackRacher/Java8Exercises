package collectionsAndJava8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		
		List<String> list = Arrays.asList("Ram", "Sam", "Jam", "Tom","Ram", "Sam" );
		
		//List to Map in normal form
		Map<String, Integer> listToMap = new HashMap<String, Integer>();
		
		for (int i = 0; i < list.size(); i++) 
		{
			if(listToMap.containsKey(list.get(i)))
			{	
				listToMap.put(list.get(i), listToMap.get(list.get(i))+1);
			}
			else
			{
				listToMap.put(list.get(i), 1);
			}	
		}
		for (Map.Entry<String, Integer> m : listToMap.entrySet()) {
			System.out.println(m.getKey() + " ==== " + m.getValue());
		}
		
		//List to map in java8
		Map<String, Integer> map = list.stream().collect(Collectors.toMap(e->e, (a)->1,Integer::sum));
		map.entrySet().forEach(System.out::println);
		
		
		//List to Map in Java8 different method
		Map<String, Long> occurence = list.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		occurence.forEach( (k, v) -> System.out.println(k + " : "+ v));
		
		// Create a String with repeated keys 
				Stream<String[]> 
					str = Stream 
							.of(new String[][] { { "GFG", "GeeksForGeeks" }, 
												{ "g", "geeks" }, 
												{ "GFG", "geeksforgeeks" },{"g","for"},{"g","geeks"} }); 

				// Get Map from String 
				// using toMap() method 
				Map<String, String> map1 = str.collect(Collectors.toMap(p -> p[0], p -> p[1], (s, a) -> s + ", " + a)); 

				// Print the Map 
				System.out.println("Map:" + map1); 
		
		
	}
}
