package com.ashokit.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ashokit.config.EmployeeDatabase;

public class EmployeeMain 
{
	public static void main(String[] args) {
		
		
		//1. How Many Male and Female employee
		
		 List<Employee2> empList = EmployeeDatabase.getEmployeeDatabase();
	     Map<String, Long> countByGender = empList.stream()
		.collect(Collectors.groupingBy(Employee2::getGender,Collectors.counting()));
	     //System.out.println(countByGender);
	     
//2.Print the all department name
	     
	     /* empList.stream()
	     .map(Employee2::getDepartment).distinct().forEach(deptName->System.out.println(deptName));*/
	     
	     List<String> deptNames = empList.stream()
	     .map(Employee2::getDepartment).distinct().collect(Collectors.toList());
	    // System.out.println(deptNames);
	     
//3. Get Avg age of the Male and Female Employee
	     Map<String, Double> averageAge = empList.stream()
	     .collect(Collectors.groupingBy
	    		 (Employee2::getGender,
	    				 Collectors.averagingInt(Employee2::getAge)));
	   //  System.out.println(averageAge);
	     
//4.Get the Details of highest Paid Employee
	     
	     Employee2 employee2 = empList.stream()
	     .collect(Collectors.maxBy(Comparator.comparing(Employee2::getSalary))).get();
	    // System.out.println(employee2);
	     
	   //4.1Get the only Name and Salary of highest Paid Employee
	     
	      String nameAndSalary = empList.stream()
	     .collect(Collectors.maxBy(Comparator.comparing(Employee2::getSalary)))
	     .map(e->e.getName()+"-"+e.getSalary()).get();
	     // System.out.println(nameAndSalary);	
	      
//5. Get the names of all employee who have joined after 2015.	
	      
			/*
			 * empList.stream() .filter(e->e.getYearOfJoining()>2015)
			 * .map(e->e.getName()+"->"+e.getYearOfJoining()).forEach(name->System.out.
			 * println(name));
			 */
	      
//6. Count the number of employee for each department
	    
	      Map<String, Long> collect = empList.stream()
	      .collect(Collectors.groupingBy(Employee2::getDepartment,Collectors.counting()));
	     // System.out.println(collect);
	      
//7. Get the Average salary of each department
	      
	      Map<String, Double> avgSalary = empList.stream()
	      .collect(Collectors.groupingBy(Employee2::getDepartment,Collectors.averagingDouble(Employee2::getSalary)));
	     // System.out.println(avgSalary);
	      
//8. Get the details of youngest male employee of Development department 
	      
			/*
			 * empList.stream() .filter(e->e.getGender().equalsIgnoreCase("Male"))
			 * .filter(e->e.getDepartment().equalsIgnoreCase("Development")).forEach(System.
			 * out::println);
			 */
	      
	      Employee2 employee22 = empList.stream()
	      .filter(e->e.getGender().equalsIgnoreCase("Male"))
	      .filter(e->e.getDepartment().equalsIgnoreCase("Development"))
	      .min(Comparator.comparing(Employee2:: getAge)).get();
	    // System.out.println(employee22);
	      
	      //By using Collector
	      
	      String youngestEmployee = empList.stream()
	      .filter(e->e.getGender().equalsIgnoreCase("Male") && e.getDepartment().equalsIgnoreCase("Development"))
	      .collect(Collectors.minBy(Comparator.comparing(Employee2::getAge)))
	      .map(e->e.getName()+"->"+e.getGender()+"->"+e.getDepartment()+"->"+e.getAge())
	      .get();
	      
	    //  System.out.println(youngestEmployee);
	      
//9. Who is most working employee in the orgnization	      
	      
	      Employee2 employee23 = empList.stream()
	      .collect(Collectors.minBy(Comparator.
	    		  comparing(Employee2::getYearOfJoining))).get();
	      //System.out.println(employee23);
//10. How Many Male and Female employee in sales dept 
	      
	      Map<String, Long> collect2 = empList.stream()
	      .filter(e->e.getDepartment().equalsIgnoreCase("Sales"))
	      .collect(Collectors.groupingBy(Employee2::getGender,Collectors.counting()));
	      //System.out.println(collect2);

//11. Get Avg salary of the Male and Female Employee
	      Map<String, Double> avgSalary2 = empList.stream()
	      .collect(Collectors.groupingBy(Employee2::getGender,
	    		  Collectors.averagingDouble(Employee2::getSalary)));
	      
	     // System.out.println(avgSalary2);\
	      
//12.List all the names of the employee of each department
	      
	      
	        empList.stream()
	         .collect(Collectors.groupingBy(Employee2::getDepartment))
	         .forEach((key,value)->
		       {
		    	// System.out.println("Dept_In="+key);
		    	// value.forEach(e->System.out.println(e.getName()));
		    	 //System.out.println("==========");
               });
	       
//13. What is the average salary and total salary of the whole organization?	
	        
	    //  System.out.println("Avg-Salary->"+empList.stream()
	         //.collect(Collectors.averagingDouble(Employee2::getSalary)));
	     // System.out.println("Total-Salary->"+empList.stream()
	        // .collect(Collectors.summingDouble(Employee2::getSalary)));
	    //  System.out.println("================================================");
	      
	      //By Using summarizingDouble
	      DoubleSummaryStatistics doubleSummaryStatistics = empList.stream()
	         .collect(Collectors.summarizingDouble(Employee2::getSalary));
	      
	   //  System.out.println(doubleSummaryStatistics.getAverage());
	   //  System.out.println(doubleSummaryStatistics.getSum());
	      
//14.Who is the oldest employee in the organization? 
	     //What is his age and which department he belongs to?
	      
	      
	      int oldestEmp = empList.stream()
	         .collect(Collectors.summarizingInt(Employee2::getAge)).getMax();
	      //System.out.println(oldestEmp);
	      
	      //another way
	      /*empList.stream()
	         .collect(Collectors.maxBy(Comparator.comparing(Employee2::getAge)))
	         .ifPresent(n->System.out.println(n.getName()+"-"+n.getAge()+"-"+n.getDepartment()));*/
	    
	      
	     
//15.Sort the List of Employee objects based on salary in Ascending order	     
	     /*   empList.stream()
	        .map(e->e.getSalary())
	        .sorted(Comparator.naturalOrder())
	        .forEach(System.out::println);*/
	        
	      
//16.Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years
	      
	      empList.stream()
	      .collect(Collectors.partitioningBy(e->e.getAge()>25))
	      .forEach((key,value)->{
	    	  System.out.println("=============================");
	    	  if(key)
	    	  {
	    		  System.out.println("Employees older than 25 years :");
	    	  }
	    	  else
	    		  {
	    		  System.out.println("Employees younger than or equal to 25 years :");
	    		  }
	    	  
	    	  value.forEach(e->System.out.println(e.getName()));
	      });
	     
  
	      
	}

}
