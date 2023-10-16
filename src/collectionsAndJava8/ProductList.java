package collectionsAndJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Product{
	private int pId;
	private String pName;
	private double price;
	public Product(int pId, String pName, double price) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.price = price;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", price=" + price + "]";
	}
	
}
public class ProductList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Product> productList = new ArrayList<Product>();
		
		Product p1 = new Product(25, "pens", 2500);
		Product p2 = new Product(59, "books", 5000);
		Product p3 = new Product(78, "pencils", 8000);
		Product p4 = new Product(20, "filesPads", 7800);
		Product p5 = new Product(89, "Planks", 4500);
		
		productList = Arrays.asList(p1, p2, p3, p4, p5);
		
		productList.forEach(System.out::println);
		System.out.println("------------------------------------------------------------------------");
		
		productList.stream().sorted(Comparator.comparing(Product::getpId)).forEach(System.out::println);
		System.out.println("------------------------------------------------------------------------");
		productList.stream().sorted(Comparator.comparing(Product::getPrice)).forEach(System.out::println);
		System.out.println("------------------------------------------------------------------------");
		productList.stream().filter(p -> p.getPrice() > 3000).forEach(System.out::println);
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Enter Product Name: ");
		String pName = sc.next();
		System.out.println("------------------------------------------------------------------------");
		System.out.println(productList.stream().filter(p -> p.getpName().equalsIgnoreCase(pName)).findAny().orElse(null));
		sc.close();
	}
}
