package collectionsAndJava8;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class SumOfEvenFibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the fibonacci range: ");
		int a = 0, b = 1, c;
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(0);
		numbers.add(1);
		int range = scanner.nextInt();
		for (int i = 2; i < range; i++) {
			c = (a + b);
			a = b;
			b = c;
			numbers.add(c);
		}
		
		numbers.forEach(System.out::println);
		int l = numbers.stream().filter(n -> (n % 2 == 0)).mapToInt(Integer::valueOf).sum();
		System.out.println();
		System.out.println(l);
		System.out.println();
		OptionalDouble avg = numbers.stream().filter(n -> (n % 2 == 0)).mapToInt(Integer::valueOf).average();
		System.out.println(avg.getAsDouble());
		
		scanner.close();
	}
}
