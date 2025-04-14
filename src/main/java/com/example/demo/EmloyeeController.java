package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmloyeeController {

    @Autowired
    private EmployeeService service;

    @RequestMapping("/selectAll")
    public String getAllEmployees(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String minAge,
        @RequestParam(required = false) String maxAge,
        @RequestParam(required = false) String startDateFrom,
        @RequestParam(required = false) String startDateTo,
        @RequestParam(required = false) String endDateFrom,
        @RequestParam(required = false) String endDateTo,
        Model model
    ) {
        List<Employee> employeeList = null;
        boolean isSearched = false;
        String errorMessage = null;

        // 入力チェック（数字と日付）
        try {
            // 年齢チェック
            Integer min = (minAge != null && !minAge.isEmpty()) ? Integer.parseInt(minAge) : null;
            Integer max = (maxAge != null && !maxAge.isEmpty()) ? Integer.parseInt(maxAge) : null;

            if (min != null && max != null && min > max) {
                errorMessage = "年齢の下限は上限以下で入力してください。";
            }

            // 日付チェック
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false); // 厳密なチェック

            if (startDateFrom != null && !startDateFrom.isEmpty()) {
                sdf.parse(startDateFrom);
            }
            if (startDateTo != null && !startDateTo.isEmpty()) {
                sdf.parse(startDateTo);
            }
            if (startDateFrom != null && startDateTo != null &&
                !startDateFrom.isEmpty() && !startDateTo.isEmpty() &&
                startDateFrom.compareTo(startDateTo) > 0) {
                errorMessage = "開始日の範囲が不正です。";
            }

            if (endDateFrom != null && !endDateFrom.isEmpty()) {
                sdf.parse(endDateFrom);
            }
            if (endDateTo != null && !endDateTo.isEmpty()) {
                sdf.parse(endDateTo);
            }
            if (endDateFrom != null && endDateTo != null &&
                !endDateFrom.isEmpty() && !endDateTo.isEmpty() &&
                endDateFrom.compareTo(endDateTo) > 0) {
                errorMessage = "終了日の範囲が不正です。";
            }

        } catch (NumberFormatException e) {
            errorMessage = "年齢には数値を入力してください。";
        } catch (ParseException e) {
            errorMessage = "日付の形式が不正です（yyyy-MM-dd）。";
        }

        if (errorMessage != null) {
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("searched", false); // 結果を表示しない
            return "selectAll";
        }

        // バリデーションOKなら検索実行
        boolean hasQuery = (name != null || minAge != null || maxAge != null ||
                            startDateFrom != null || startDateTo != null ||
                            endDateFrom != null || endDateTo != null);

        if (hasQuery) {
            isSearched = true;

            boolean isAllEmpty = (name == null || name.isEmpty()) &&
                                 (minAge == null || minAge.isEmpty()) &&
                                 (maxAge == null || maxAge.isEmpty()) &&
                                 (startDateFrom == null || startDateFrom.isEmpty()) &&
                                 (startDateTo == null || startDateTo.isEmpty()) &&
                                 (endDateFrom == null || endDateFrom.isEmpty()) &&
                                 (endDateTo == null || endDateTo.isEmpty());

            if (isAllEmpty) {
                employeeList = service.selectAll();
            } else {
                Employee condition = new Employee();
                condition.setName(name);
                if (minAge != null && !minAge.isEmpty()) {
                    condition.setAge(Integer.parseInt(minAge));
                }
                if (maxAge != null && !maxAge.isEmpty()) {
                    condition.setMaxAge(Integer.parseInt(maxAge));
                }
                condition.setStartDate(startDateFrom);
                condition.setStartDateTo(startDateTo);
                condition.setEndDateFrom(endDateFrom);
                condition.setEndDate(endDateTo);

                employeeList = service.search(condition);
            }

            model.addAttribute("kensyuEmployee", employeeList);
        }

        model.addAttribute("searched", isSearched);
        return "selectAll";
    }
    @RequestMapping("/test")
    public String showTestPage(@RequestParam(required = false) List<Integer> ids, Model model) {
        model.addAttribute("selectedIds", ids); 
        return "test"; 
    }

}