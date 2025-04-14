package com.example.demo;

public class Employee {
	private int id;
	private String name;
	private int age;
	private String startDate;
	private String endDate;
	private Integer maxAge;
	private String startDateTo;
	private String endDateFrom;
	
	public Employee() {};
	public Employee(int id, String name, int age, String startDate, String endDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.startDate = startDate;
        this.endDate = endDate;
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		 this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		 this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		 this.age = age;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		 this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		 this.endDate = endDate;
	}


	public Integer getMaxAge() {
	    return maxAge;
	}
	public void setMaxAge(Integer maxAge) {
	    this.maxAge = maxAge;
	}

	public String getStartDateTo() {
	    return startDateTo;
	}
	public void setStartDateTo(String startDateTo) {
	    this.startDateTo = startDateTo;
	}

	public String getEndDateFrom() {
	    return endDateFrom;
	}
	public void setEndDateFrom(String endDateFrom) {
	    this.endDateFrom = endDateFrom;
	}
}
