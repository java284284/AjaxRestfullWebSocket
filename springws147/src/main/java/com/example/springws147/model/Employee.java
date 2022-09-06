package com.example.springws147.model;

public class Employee {
	String name;
	String addreee;
	Integer salary;
	
	public Employee(String name, String addreee, Integer salary) {
		super();
		this.name = name;
		this.addreee = addreee;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddreee() {
		return addreee;
	}
	public void setAddreee(String addreee) {
		this.addreee = addreee;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	
	
	
	
}
