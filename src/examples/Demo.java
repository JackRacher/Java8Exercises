package examples;

import java.util.ArrayList;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(100, "Mani", "Read"));
        list.add(new Employee(100, "Mani", "Write"));
        list.add(new Employee(100, "Mani", "Delete"));
        list.add(new Employee(101, "Rajesh", "Read"));
        list.add(new Employee(101, "Rajesh", "write"));
        list.add(new Employee(101, "Rajesh", "Delete"));

 
        
        List<Employee> list2 = new ArrayList<Employee>();
       
        
         for(Employee e : list) 
         {
        	 if(list2.isEmpty()) {
           		 list2.add(e);
           	 }
              for(int i = 0; i < list2.size(); i++) {
      			Employee e1 = list2.get(i);
            	  if(e.getId() == e1.getId() && !e.getOperation().equalsIgnoreCase(e1.getOperation())) {
                  	e1.setOperation(e1.getOperation() +"," + e.getOperation());
                  }
            	  else {
            		  int count = 0;
            		  for (int j = 0; j < list2.size(); j++) {
						Employee emp = list2.get(j);
						if(emp.getId() == e.getId()) {
							count = 1;
						}
					}
            		  if(count==0) {
            			  list2.add(e);
            		  }
            		  
            	  }
               }
          }
         System.out.println(list2);
         
    }
}
