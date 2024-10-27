package com.test.config;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.model.Employee;

public class EmployeeDatabase {
	
	
	  public static List<Employee> fetchEmployees() {
	        ObjectMapper mapper = new ObjectMapper();
	        try {
	            return mapper
	                    .readValue(new File("employees.json"), new TypeReference<List<Employee>>() {
	                    });
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

}
