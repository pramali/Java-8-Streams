package com.test;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureLimitation {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service=Executors.newFixedThreadPool(10);
		
		Future<List<Integer>> future = service.submit(()-> {
			
			System.out.println("Name="+Thread.currentThread().getName());
			//System.out.println("Divide By 10/0=>"+10/0);
			Thread.sleep(5000);
			return Arrays.asList(1,2,3,4,5);	
		});
		List<Integer> list = future.get();
	
		System.out.println(list);
		
		
		CompletableFuture<String> completableFuture=new CompletableFuture<>();
	
		completableFuture.complete("Welcome to Java8");
		
		String message = completableFuture.get();
		System.out.println("Message="+message);
		System.out.println("Done");
				
	}
	

}
