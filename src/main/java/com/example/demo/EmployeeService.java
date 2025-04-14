package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeMapper mapper;
	
	public List<Employee> selectAll(){
		return mapper.selectAll();
	}
	
public List <Employee> selectById(int id){
	return mapper.selectById(id);
	}

public List <Employee> selectByName(String name){
	return mapper.selectByName(name);
	}

public List <Employee> selectByAge(int age){
	return mapper.selectByAge(age);
	}

public List <Employee> selectByStartDate(String StartDate){
	return mapper.selectByStartDate(StartDate);
	}

public List <Employee> selectByEndDate(String EndDate){
	return mapper.selectByEndDate(EndDate);
	}
public List<Employee> search(Employee condition) {
    return mapper.search(condition);
}
}
