package collectionsAndJava8;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOccurence {

	public static void main(String[] args) {
		String name = "java";
		String[] chars = name.split("");
		
		Map<Object, Long> values = Arrays.stream(chars).collect(Collectors.groupingBy(c -> c , Collectors.counting()));
        values.forEach( (k, v) -> System.out.println(k + " : "+ v)        );
	}
}
