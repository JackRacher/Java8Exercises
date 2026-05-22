package collectionsAndJava8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Student{
	private String name;
	private int className;
	
	public Student(String name, int className) {
		super();
		this.name = name;
		this.className = className;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClassName() {
		return className;
	}
	public void setClassName(int className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", className=" + className + "]";
	}
}

public class School {
	
	public static void main(String[] args) {
		Student student1 = new Student("ram",1);
		Student student2 = new Student("sam",2);
		Student student3 = new Student("jam",5);
		Student student4 = new Student("ram",1);
		Student student5 = new Student("tom",4);
		Student student6 = new Student("rob",8);
		Student student7 = new Student("bob",3);
		Student student8 = new Student("kim",10);
		Student student9 = new Student("raj",10);
		Student student10 = new Student("kal",1);
		
		List<Student> students = new ArrayList<>();
		students.add(student10);
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
		students.add(student6);
		students.add(student7);
		students.add(student8);
		students.add(student9);
		
//		students.forEach(System.out::println);
//		
//		students.stream().collect(Collectors.groupingBy(Student::getClassName, Collectors
//				.collectingAndThen(Collectors.toList(), list -> list.stream()
//				.sorted(Comparator.comparing(Student::getName))
//				.collect(Collectors.toList()))))
//				.entrySet()
//				.forEach(System.out::println);
		
		students.stream().distinct().collect(Collectors.toMap(Student::getClassName, Student::getName,(a, b)->b)).forEach((k,v)->{
			System.out.println(k+"-"+v);
		});
		System.out.println("---------------------------------------------");
		students.stream().map(Student::getName).collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.reverseOrder()))).forEach(System.out::println);
		
		
		students.stream().collect(Collectors.toMap(Student::getClassName, Student::getName, (a,b)->a, LinkedHashMap<Integer, String>::new)).entrySet().forEach(System.out::println);
		
		
		students.stream().collect(Collectors.toMap(Student::getClassName, Student::getName, (a,b)->a, LinkedHashMap<Integer, String>::new))
							.entrySet().stream()
							.map(Entry::getKey).collect(Collectors.toCollection(() -> new TreeSet<Integer>(Comparator.reverseOrder()))).forEach(System.out::println);
		
		List<List<Student>> l = students.stream().collect(Collectors.groupingBy(Student::getClassName)).entrySet().stream().map(Entry::getValue).collect(Collectors.toList());
		l.stream().flatMap(List::stream)
					.collect(Collectors.toList())
					.forEach(System.out::println);
		System.out.println("---------------------------------------------");
		l.stream().flatMap(List::stream)
        .collect(Collectors.collectingAndThen(
                Collectors.toCollection(() ->
                        new TreeSet<>(Comparator.comparing(
                                s -> s.getName() + "#" + s.getClassName()
                        ))
                ),
                ArrayList::new
        ))
        .forEach(System.out::println);	
	}
}
