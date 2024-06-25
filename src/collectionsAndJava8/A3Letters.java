package collectionsAndJava8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A3Letters {

	public static void main(String[] args) {
		String string1 = "madam";
		
		List<String> names = new ArrayList<String>();
		names.add("1");
		names.add("3");
		names.add("3");
		names.add("5");
		names.add("5");
		names.add("6");
		names.add("7");
		System.out.println();
		/*stream operation to get sum, count, max, min and average*/
		System.out.println(names.stream().map(Integer::parseInt).collect(Collectors.summarizingInt(Integer::intValue)).getSum());
		System.out.println();
		/*stream operation to get the maximum value from the list*/
		System.out.println(names.stream().map(Integer::parseInt).filter(i->i>3).max(Integer::compareTo).get());
		System.out.println();
		/*stream operation to get sum, count, max, min and average*/
		System.out.println(names.stream().map(Integer::parseInt).sorted(Comparator.comparingInt(Integer::intValue).reversed()).findFirst());
		System.out.println();
		names.stream().filter(s->s.startsWith("a")).map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println();
		names.stream().collect(Collectors.toSet()).forEach(System.out::println);
		System.out.println();
		System.out.println(names.stream().map(Integer::parseInt).sorted(Comparator.comparing(Integer::intValue).reversed()).skip(1).findFirst().get());
		//search(names).forEach(System.out::println);
		System.out.println();
		System.out.println(names.stream().count());
		System.out.println();
		names.stream().collect(Collectors.groupingBy(s->s, Collectors.counting())).forEach((k,v)->System.out.println("Key: "+k+" Value: "+v));
		System.out.println();
		
		
//		if(Stream.of((string1+",").split(",")).map(s-> new StringBuilder(s).reverse()).anyMatch(s->String.valueOf(s).equals(string1))) {
//			System.out.println("Palindrom");
//		}
//		else {
//			System.out.println("Not-Palindrom");
//		}
		
		String s = "000012345";
		System.out.println(Integer.parseInt(s));
//		
//		names.stream().map(s-> new StringBuilder(s).reverse()).collect(Collectors.toList()).forEach(System.out::println);
//		System.out.println();
//		if(names.stream().map(s-> new StringBuilder(s).reverse()).anyMatch(s1->String.valueOf(s1).equals(string))) {
//			System.out.println("palindrome");
//		}
//		else {
//			System.out.println("Not-palindrome");
//		}
	}

	public static List<String> search(List<String> list) {
		
		list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
		
		return list.stream().filter(string -> string.length() == 3 && string.charAt(0) == 'a').collect(Collectors.toList());
		
	} 
}
