package collectionsAndJava8;

import java.util.HashSet;
import java.util.Set;

class SetCopy{
	
	public int copySet(Set<Integer> source, Set<Integer> destination) {
		int result = 1;
		
		if(source == null && destination == null) {
			return result;
		}
		
		for (Integer integer : source) {
			destination.add(integer);
		}
		result = 0;
		return result;
	}
}
public class CopySetProgram {

	public static void main(String[] args) {
		Set<Integer> source = new HashSet<Integer>();
		Set<Integer> destnation = new HashSet<Integer>();
		source.add(15);
		source.add(19);
		source.add(45);
		source.add(78);
		source.add(25);
		
		destnation.add(85);
		destnation.add(96);
		
		SetCopy setCopy = new SetCopy();
		
		int result = setCopy.copySet(source, destnation);
		
		System.out.println(result);
		
		for (Integer integer : destnation) {
			System.out.println(integer);
		}
	}
}
