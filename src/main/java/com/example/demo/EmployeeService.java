package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeMapper mapper;
	
//	public void insert(Employee employee) {
//		mapper.insert(Employee);
//	}
}
