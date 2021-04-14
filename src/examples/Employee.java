package examples;

public class Employee {

	private int id;
	private String name;
	private String operation;
	public Employee() {
		
	}
	
	public Employee(int id, String name, String operation) {
		super();
		this.id = id;
		this.name = name;
		this.operation = operation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", operation=" + operation + "]";
	}
	
	
}
