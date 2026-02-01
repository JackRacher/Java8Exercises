package collectionsAndJava8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		System.out.println("-------------------------------------------");
		//List to map in java8
		Map<String, Integer> map = list.stream().collect(Collectors.toMap(e->e, (a)->1,Integer::sum));
		map.entrySet().forEach(System.out::println);
		System.out.println("-------------------b/n------------------------");
		Map<String, Long> myMap = list.stream().collect(Collectors.groupingBy(s->s, Collectors.counting()));
		myMap.entrySet().forEach(System.out::println);
		System.out.println("-------------------------------------------");
		
		//List to Map in Java8 different method
		Map<String, Long> occurence = list.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		occurence.entrySet().forEach(System.out::println);
		//occurence.forEach( (k, v) -> System.out.println(k + " : "+ v));
		
		// Create a String with repeated keys 
//				Stream<String[]> 
//					str = Stream 
//							.of(new String[][] { { "GFG", "GeeksForGeeks" }, 
//												{ "g", "geeks" }, 
//												{ "GFG", "geeksforgeeks" },{"g","for"},{"g","geeks"} }); 
					
				String[][] strDoubleArr = new String[4][2];
				strDoubleArr[0][0] = "GFG";
				strDoubleArr[0][1] = "GeeksForGeeks";
				strDoubleArr[1][0] = "g";
				strDoubleArr[1][1] = "geeks";
				strDoubleArr[2][0] = "GFG";
				strDoubleArr[2][1] = "geeksforgeeks";
				strDoubleArr[3][0] = "g";
				strDoubleArr[3][1] = "for";
				
				Arrays.asList(strDoubleArr).stream().collect(Collectors.toMap(a -> a[0], a -> a[1], (a, b) -> a+","+b, LinkedHashMap::new));
				
				

				// Get Map from String 
				// using toMap() method 
				Map<String, String> map1 = Arrays.asList(strDoubleArr).stream().collect(Collectors.groupingBy(a -> a[0], Collectors.mapping(a -> a[1], Collectors.joining(","))));
						//str.collect(Collectors.groupingBy(arr -> arr[0], Collectors.mapping(arr -> arr[1], Collectors.joining(","))));
						
				LinkedHashMap<String, String> map2 = Arrays.asList(strDoubleArr).stream().collect(Collectors.toMap(a -> a[0], a -> a[1], (a, b) -> a+","+b, LinkedHashMap::new));
//						str.collect(Collectors.toMap(
//														p -> p[0],
//														p -> p[1],
//														(s, a) -> s + ", " + a,
//														LinkedHashMap::new)); 

				// Print the Map 
				System.out.println("Map:" + map1); 
				System.out.println("Map:" + map2);
	}
}
