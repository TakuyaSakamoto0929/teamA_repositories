package com.example.demo;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class Service {
	@Autowired
	private Mapper mapper;
	
//	public void insert(Employee employee) {
//		mapper.insert(Employee);
//	}
}
