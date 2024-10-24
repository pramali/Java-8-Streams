package com.cg.test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

import com.cg.config.EmployeeDatabase;
import com.cg.model.Employee2;

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
	      System.out.println(nameAndSalary);		
	}
}
