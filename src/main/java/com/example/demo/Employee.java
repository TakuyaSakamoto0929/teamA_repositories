package com.example.demo;

public class Employee {
	private String name;
	private int age;
	private String pass;

	public Employee(String name, int age , String pass) {
		this.name = name;
		this.age = age;
		this.pass =pass;
	}
	
	//GetterとSetter
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}

