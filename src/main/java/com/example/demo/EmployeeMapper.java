package com.example.demo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {
	@Insert("INSERT INTO  employeeVALUES(#{name},#{age},#{pass})")
	void insert (Employee employee );
}
