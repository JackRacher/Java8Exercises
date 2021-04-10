package collectionsAndJava8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ListSorter{
	public static List<Integer> listSorter(List<Integer> intList){
		List<Integer> list = intList.stream().sorted().collect(Collectors.toList());
		return list;
	}
}
public class ListSorterProgram {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(8);
		list.add(9);
		list.add(6);
		list.add(7);
		list.add(32);
		list.add(17);
		list.add(145);
		list.add(200);
		
		ListSorter.listSorter(list).forEach(System.out::println);
	}
}
