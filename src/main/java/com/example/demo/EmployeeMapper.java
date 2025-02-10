package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {
	 @Select("<script>" +
	            "SELECT * FROM kensyuEmployee WHERE 1=1" +
	            "<if test='name != null'> AND name LIKE CONCAT('%', #{name}, '%')</if>" +
	            "<if test='ageFrom != null'> AND age >= #{ageFrom}</if>" +
	            "<if test='ageTo != null'> AND age <= #{ageTo}</if>" +
	            "<if test='startDate != null'> AND start_date >= #{startDate}</if>" +
	            "<if test='endDate != null'> AND end_date <= #{endDate}</if>" +
	            "</script>")
	    List<Employee> searchEmployees(@Param("name") String name,
	                                   @Param("ageFrom") Integer ageFrom,
	                                   @Param("ageTo") Integer ageTo,
	                                   @Param("startDate") String startDate,
	                                   @Param("endDate") String endDate);
	}
