package com.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.model.Employee;

public class RunAsyncDemo {

	public Void saveEmployees(File jsonFile) throws InterruptedException, ExecutionException {
		ObjectMapper mapper = new ObjectMapper();

		CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {

			try {
				List<Employee> employees = mapper.readValue(jsonFile, new TypeReference<List<Employee>>() {
				});
				System.out.println("Name=" + Thread.currentThread().getName());
				// Thread.sleep(5000);
				System.out.println(employees.size());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		return runAsync.get();

	}

	public Void saveEmployeesWithCustomExecutor(File jsonFile) throws InterruptedException, ExecutionException {
		ObjectMapper mapper = new ObjectMapper();

		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);

		CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {

			try {
				List<Employee> employees = mapper.readValue(jsonFile, new TypeReference<List<Employee>>() {
				});
				System.out.println("Name=" + Thread.currentThread().getName());
				System.out.println(employees.size());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}, newFixedThreadPool);

		return runAsync.get();

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		RunAsyncDemo runAsyncDemo = new RunAsyncDemo();
		runAsyncDemo.saveEmployees(new File("employees.json"));
		runAsyncDemo.saveEmployeesWithCustomExecutor(new File("employees.json"));

	}

}
