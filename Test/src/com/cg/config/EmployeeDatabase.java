package com.cg.config;

import java.util.Arrays;
import java.util.List;

import com.cg.model.Employee2;

public class EmployeeDatabase {
	
    public static List<Employee2> getEmployeeDatabase()
    {
    	return Arrays.asList(
    			new Employee2(1, "Jhansi", "Female", "HR", 2011, 25000.0,32),
    			new Employee2(2, "Smith", "Male", "Sale", 2015,13500.0,25),
    			new Employee2(3, "David", "Male", "Infra", 2012, 18000.0,29),
    			new Employee2(4, "Orlen", "Male", "Development", 2014, 32500.0,28),
    			new Employee2(5, "Charles", "Male", "HR", 2013, 22700.0,27),
    			new Employee2(6, "Cathy", "Male", "Security", 2016, 10500.0,43),
    			new Employee2(7, "Ramesh", "Male", "Finance", 2010, 27000.0,35),
    			new Employee2(8, "Suresh", "Male", "Development", 2015, 34500.0,31),
    			new Employee2(9, "Gita", "Female", "Sales", 2016, 11500.0,24),
    			new Employee2(10, "Mahesh","Male", "Security", 2015, 11000.0,38),
    			new Employee2(11, "Gauri", "Female", "Infra", 2014, 15700.0,27),
    			new Employee2(12, "Nitin", "Male", "Development",2016, 28200.0,25),
    			new Employee2(13, "Swati", "Female", "Finance", 2013, 21300.0,27),
    			new Employee2(14, "Butler", "Male","Sales",2017, 10700.0,24),
    			new Employee2(15, "Ashok", "Male", "Infra",2018, 12700.0,23),
    			new Employee2(16, "Sanvi", "Female", "Development",2015, 28900.0,26)
    			);
    }

}
