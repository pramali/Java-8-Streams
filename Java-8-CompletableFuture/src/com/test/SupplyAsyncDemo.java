package com.test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.test.config.EmployeeDatabase;
import com.test.model.Employee;

public class SupplyAsyncDemo
{
	 public List<Employee> getEmployees() throws ExecutionException, InterruptedException {
		 ExecutorService customExecutor = Executors.newCachedThreadPool();
		 CompletableFuture<List<Employee>> supplyAsync = CompletableFuture.supplyAsync(()->
		 {
			 System.out.println("Executed By="+Thread.currentThread().getName());
			 return EmployeeDatabase.fetchEmployees();
			 
		 },customExecutor);
		 return supplyAsync.get();
	 }
	
	
    public static void main(String[] args) throws ExecutionException, InterruptedException {
    	
    	SupplyAsyncDemo supplyAsyncDemo=new SupplyAsyncDemo();
    	supplyAsyncDemo.getEmployees().forEach(e->System.out.println(e));
		
	}
}
