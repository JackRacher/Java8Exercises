package collectionsAndJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class ArrayToList{
	public static List<String> arrayToList(String[] array){
		
		if(array == null)
			return null;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		System.out.println(list.size());
		return list;
	}
}
public class ArrayToListProgram {

	public static void main(String[] args) {
		String[] array = {"zoom","ram", "jam", "sam", "tom","jam", "sam", "tom"};
		//Arrays.sort(array);
		List<String> list = Arrays.asList(array).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().forEach(System.out::println);
		list.forEach(System.out::println);
		System.out.println("-----------------------------");
		
		for (String string : ArrayToList.arrayToList(array)) {
			System.out.println(string);
		}
	}
}
