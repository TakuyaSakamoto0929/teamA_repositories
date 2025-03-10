package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    // 全件取得
    public List<Employee> getAllEmployees() {
        return employeeMapper.findAll();
    }

    // IDで取得
    public Employee getEmployeeById(int id) {
        return employeeMapper.findById(id);
    }

    // 名前検索（部分一致）
    public List<Employee> searchByName(String name) {
        return employeeMapper.findByName(name);
    }

    // 年齢範囲検索
    public List<Employee> searchByAgeRange(int minAge, int maxAge) {
        return employeeMapper.findByAgeRange(minAge, maxAge);
    }

    // 期間検索（開始日～終了日）
    public List<Employee> searchByDateRange(String startDate, String endDate) {
        return employeeMapper.findByDateRange(startDate, endDate);
    }
}