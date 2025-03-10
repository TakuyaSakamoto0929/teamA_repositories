package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/employees")
public class EmloyeeController {

    private final EmployeeService employeeService;

    public EmloyeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // 検索画面の表示
    @GetMapping("/search")
    public String showSearchPage() {
        return "search";
    }

    // 名前検索（部分一致）
    @GetMapping("/search/name")
    @ResponseBody
    public List<Employee> searchByName(@RequestParam String name) {
        return employeeService.searchByName(name);
    }

    // 年齢範囲検索
    @GetMapping("/search/age")
    @ResponseBody
    public List<Employee> searchByAgeRange(@RequestParam int minAge, @RequestParam int maxAge) {
        return employeeService.searchByAgeRange(minAge, maxAge);
    }

    // 期間検索（開始日～終了日）
    @GetMapping("/search/date")
    @ResponseBody
    public List<Employee> searchByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        return employeeService.searchByDateRange(startDate, endDate);
    }
}