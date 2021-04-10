package collectionsAndJava8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class A3Letters {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("ant");
		names.add("animal");
		names.add("pens");
		names.add("aex");
		names.add("alo");
		names.add("all");
		search(names).forEach(System.out::println);
	}

	public static List<String> search(List<String> list) {
		
		return list.stream().filter(string -> string.length() == 3 && string.charAt(0) == 'a').collect(Collectors.toList());
		
	} 
}
