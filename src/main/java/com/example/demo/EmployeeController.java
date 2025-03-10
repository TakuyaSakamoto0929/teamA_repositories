package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class EmployeeController {
	@PostMapping("/createConfirm")
	public String registration(
		Model m,
		@RequestParam("name") String name,
		@RequestParam("age") String age,
		@RequestParam("pass") String pass
		) {
		m.addAttribute("name" ,name);
		m.addAttribute("age" ,age);
		m.addAttribute("name" ,name);
		return "confirm";
	}
}

