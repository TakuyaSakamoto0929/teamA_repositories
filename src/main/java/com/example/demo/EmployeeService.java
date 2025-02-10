package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	  @Autowired
	    private EmployeeMapper employeeMapper;
	    
	    public List<Employee> searchEmployees(String name, Integer ageFrom, Integer ageTo, String startDate, String endDate) {
	        return employeeMapper.searchEmployees(name, ageFrom, ageTo, startDate, endDate);
	    }
}
