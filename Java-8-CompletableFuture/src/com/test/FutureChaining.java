package com.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import com.test.config.EmployeeDatabase;
import com.test.model.Employee;

public class FutureChaining {
	
	 public  CompletableFuture<Void> sendReminderToEmployee() 
	 {
		 ExecutorService customExecutor= Executors.newFixedThreadPool(5);
		 CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(()->{
			  System.out.println("fetchEmployee : " + Thread.currentThread().getName());
			 return EmployeeDatabase.fetchEmployees();
		 },customExecutor).thenApplyAsync((employees)->{
			  System.out.println("filter new joiner employee  : " + Thread.currentThread().getName());
			 return employees.stream()
					 .filter(employee->employee.getNewJoiner().equalsIgnoreCase("TRUE"))
					 .collect(Collectors.toList());
		 },customExecutor).thenApplyAsync((employees)->{
			   System.out.println("filter training not complete employee  : " + Thread.currentThread().getName());
			 return employees.stream()
					 .filter(employee->employee.getLearningPending().equalsIgnoreCase("TRUE"))
					 .collect(Collectors.toList());
		 },customExecutor).thenApplyAsync((employees)->{
			 System.out.println("get emails  : " + Thread.currentThread().getName());
			 return employees.stream()
					 .map(Employee::getEmail)
					 .collect(Collectors.toList());
		 },customExecutor).thenAcceptAsync((emails)->{
			  System.out.println("send email  : " + Thread.currentThread().getName());
			 emails.forEach(FutureChaining::sendEmail);	 
		 },customExecutor);
		 
		 // System.out.println("email sent");
		 return completableFuture;
	 }
	
	 
	  public static void sendEmail(String email) {
	        System.out.println("sending training reminder email to : " + email);
		
	    }
	  
	 public static void main(String[] args) {
		 FutureChaining futureChaining=new FutureChaining();
		 CompletableFuture<Void> sendReminderToEmployee = futureChaining.sendReminderToEmployee();
	 }

}
