package com.cg.model;

public class Employee2 {
	
	private Integer id;
	private String name;
	private String gender;
	private String department;
	private Integer yearOfJoining;
	private Double salary;
	private Integer age;
	
	public Employee2(Integer id, String name, String gender, String department, Integer yearOfJoining, Double salary,
			Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(Integer yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee2 [id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department
				+ ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + ", age=" + age + "]";
	}
	
	
	

}
