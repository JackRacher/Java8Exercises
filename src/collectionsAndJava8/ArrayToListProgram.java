package collectionsAndJava8;

import java.util.ArrayList;
import java.util.List;

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
		String[] array = {"ram", "jam", "sam", "tom"};
		
		for (String string : ArrayToList.arrayToList(array)) {
			System.out.println(string);
		}
	}
}
