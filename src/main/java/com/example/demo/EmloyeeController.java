package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmloyeeController {
	@Autowired
    private EmployeeService employeeService;

    @GetMapping("/search")
    public List<Employee> searchEmployees(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Integer ageFrom,
        @RequestParam(required = false) Integer ageTo,
        @RequestParam(required = false) String startDate,
        @RequestParam(required = false) String endDate) {
        
        return employeeService.searchEmployees(name, ageFrom, ageTo, startDate, endDate);
    }
}
