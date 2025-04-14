package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface EmployeeMapper {
	@Select("SELECT * FROM kensyuEmployee")
	List<Employee> selectAll();
	
	@Select("SELECT * FROM kensyuEmployee WHERE id = #{id}")
	List<Employee> selectById(int id);
	
	@Select("SELECT * FROM kensyuEmployee WHERE name = #{name}")
	List<Employee> selectByName(String name);
	
	@Select("SELECT * FROM kensyuEmployee WHERE age = #{age}")
	List<Employee> selectByAge(int age);
	
	@Select("SELECT * FROM kensyuEmployee WHERE startDate > = #{startDate}")
	List<Employee> selectByStartDate(String startDate);
	
	@Select("SELECT * FROM kensyuEmployee WHERE endDate < = #{endDate}")
	List<Employee> selectByEndDate(String endDate);
	
	@SelectProvider(type = EmployeeSqlProvider.class, method = "buildSearchQuery")
	List<Employee> search(Employee employee);  // Employee に条件を詰めて渡す


	
}
