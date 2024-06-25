package collectionsAndJava8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
	
	private int employee_id;
	private String employee_name;
	private int employee_age;
	private String gender;
	private String department;
	private double employee_salary;
	
	public Employee(int employee_id, String employee_name, int employee_age, String gender, String department,
			double employee_salary) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_age = employee_age;
		this.gender = gender;
		this.department = department;
		this.employee_salary = employee_salary;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public int getEmployee_age() {
		return employee_age;
	}

	public void setEmployee_age(int employee_age) {
		this.employee_age = employee_age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getEmployee_salary() {
		return employee_salary;
	}

	public void setEmployee_salary(double employee_salary) {
		this.employee_salary = employee_salary;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_age="
				+ employee_age + ", gender=" + gender + ", department=" + department + ", employee_salary="
				+ employee_salary + "]";
	}
	
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee(101,"Ram",25,"Male","Admin",25000));
		employees.add(new Employee(102,"Rajesh",23,"Male","PMO",20000));
		employees.add(new Employee(103,"Venu",26,"Male","Developer",40000));
		employees.add(new Employee(104,"Pavi",25,"Female","Developer",40000));
		employees.add(new Employee(105,"Ajay",27,"Male","IT",26000));
		employees.add(new Employee(106,"Vijay",29,"Male","IT",30000));
		employees.add(new Employee(107,"Rao",27,"Male","IT",29000));
		employees.add(new Employee(108,"Sruthin",25,"Male","Finance",32000));
		employees.add(new Employee(109,"Suma",29,"Female","Payroll",39000));
		employees.add(new Employee(110,"Sri",25,"Female","BDM",27000));
		
		System.out.println("-----------------------Total Employees--------------------------");
		employees.stream().forEach(System.out::println);
		System.out.println("-----------------------Female Employees-------------------------");
		employees.stream().filter(e->e.getGender().equalsIgnoreCase("female")).forEach(System.out::println);
		System.out.println("-----------------------Total employees average salary------------");
		System.out.println(employees.stream().collect(Collectors.averagingDouble(Employee::getEmployee_salary)));
		System.out.println("-----------------------Total employees list avarage, sum, count, min and max details-------------------------");
		System.out.println(employees.stream().collect(Collectors.summarizingDouble(Employee::getEmployee_salary)).getAverage());
		System.out.println(employees.stream().collect(Collectors.summarizingDouble(Employee::getEmployee_salary)).getSum());
		System.out.println(employees.stream().collect(Collectors.summarizingDouble(Employee::getEmployee_salary)).getCount());
		System.out.println(employees.stream().collect(Collectors.summarizingDouble(Employee::getEmployee_salary)).getMin());
		System.out.println(employees.stream().collect(Collectors.summarizingDouble(Employee::getEmployee_salary)).getMax());
		System.out.println("-----------------------Total employees count on gender wise-------------------------");
		employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())).forEach((k,v)->System.out.println(k+" : "+v));
		System.out.println("-----------------------Total departments------------------------");
		employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		System.out.println("-----------------------Total employees salary greater thatn avg salary ------------------------");
		employees.stream().filter(e->e.getEmployee_salary()>(employees.stream().collect(Collectors.averagingDouble(Employee::getEmployee_salary)))).forEach(System.out::println);
		System.out.println("-----------------------Total employees salary greater thatn avg salary and grouping with department wise ------------------------");
		employees.stream().filter(e->e.getEmployee_salary()>(employees.stream().collect(Collectors.averagingDouble(Employee::getEmployee_salary))))
		.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).forEach((k,v)->System.out.println(k+" : "+v));;
		
	}
	

}
