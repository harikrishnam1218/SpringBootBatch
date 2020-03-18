package com.practice.model;

public class Person {

	private Long pid;
	
	private String firstname;
	
	private String lastname;
	
	private String designation;
	
	private Double salary;
	
	private Double experience;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getExperience() {
		return experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}

	public Person(String firstname, String lastname, String designation, Double salary, Double experience) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.designation = designation;
		this.salary = salary;
		this.experience = experience;
	}

	public Person() {
		super();
	}
	

}
