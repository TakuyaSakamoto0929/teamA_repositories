package com.example.demo;

import org.apache.ibatis.jdbc.SQL;

public class EmployeeSqlProvider {
    public String buildSearchQuery(Employee emp) {
        return new SQL() {{
            SELECT("*");
            FROM("kensyuEmployee");

            if (emp.getName() != null && !emp.getName().isEmpty()) {
                WHERE("name LIKE CONCAT('%', #{name}, '%')");
            }

            if (emp.getAge() > 0) {
                WHERE("age >= #{age}");
            }
            if (emp.getMaxAge() != null) {
                WHERE("age <= #{maxAge}");
            }

            if (emp.getStartDate() != null && !emp.getStartDate().isEmpty()) {
                WHERE("startDate >= #{startDate}");
            }
            if (emp.getStartDateTo() != null && !emp.getStartDateTo().isEmpty()) {
                WHERE("startDate <= #{startDateTo}");
            }

            if (emp.getEndDateFrom() != null && !emp.getEndDateFrom().isEmpty()) {
                WHERE("endDate >= #{endDateFrom}");
            }
            if (emp.getEndDate() != null && !emp.getEndDate().isEmpty()) {
                WHERE("endDate <= #{endDate}");
            }

        }}.toString();
    }
}
