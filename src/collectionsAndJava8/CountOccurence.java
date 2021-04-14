package collectionsAndJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOccurence {

	public static void main(String[] args) {
		String name = "java";
		String[] chars = name.split("");
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(40);
		list.add(10);
		list.add(90);
		list.add(80);
		list.add(20);
		list.add(30);
		list.add(50);
		list.add(70);
		
//		Map<Object, Long> values = Arrays.stream(chars).collect(Collectors.groupingBy(c -> c , Collectors.counting()));
		Map<Object, Long> value = list.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		
        value.forEach( (k, v) -> System.out.println(k + " : "+ v)        );
        
        
	}
}
