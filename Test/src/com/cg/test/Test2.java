package com.cg.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.cg.model.Employee;

public class Test2 {
	
	public static void main(String[] args) {
		
	  Employee employee1=new Employee(101, "JOHN", 1000.00);
	  Employee employee2=new Employee(102, "WILLIAM", 5000.00);
	  Employee employee3=new Employee(103, "SHANE", 3000.00);
	  Employee employee4=new Employee(104, "DAVID", 5000.00);
	  Employee employee5=new Employee(105, "JOHN", 2000.00);
	  List<Employee> empList = Arrays.asList(employee1,employee2,employee3,employee4,employee5);
	  Employee employee = empList.stream()
	  .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get();
	
	 // System.out.println(employee);
	  
	  
	  Employee employee6 = empList.stream()
	  .collect(Collectors.minBy(Comparator.comparing(Employee::getSalary)))
	  .get();
	//  System.out.println(employee6);
	  
	  
	  Double avgSalary = empList.stream()
	  .collect(Collectors.averagingDouble(Employee::getSalary));
	//  System.out.println(avgSalary);
	  
	   Map<Double, List<Employee>> collect = empList.stream()
	  .collect(Collectors.groupingBy(Employee::getSalary));
	  
	 // System.out.println(collect);
	  /* long start=0;
       long end=0;
       long start1=0;
       long end1=0;
       
	  
	   int n=100;
		  
		  List<Integer>  numList=new ArrayList<>();
				  
		  for(int i=1;i<=n;i++)
		  {
			  numList.add(i);
		  }
		  
		  
		  
		  System.out.println("Sequential Stream Started...");
	   start=System.currentTimeMillis();
	   numList.forEach(System.out::println);
	  end=System.currentTimeMillis();
	  System.out.println("Sequential Stream ENDED..."+(end-start));
	  
	  System.out.println("Parallel Stream Started...");
	   start1=System.currentTimeMillis();
	   numList.stream().parallel().forEach(System.out::println);
	  end1=System.currentTimeMillis();
	  System.out.println("Parallel Stream ENDED..."+(end1-start1));*/
	   
	  
	   List<String> names = Arrays.asList("JOHN","DAVID","KANE");
	 
	   names.stream().spliterator().forEachRemaining(n->System.out.println(n));
	  
	  
	 
	  
	 
	  
	}

}
