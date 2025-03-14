package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ControllerAdvice
public class MyController {
	
	
	@GetMapping("/main")
	public String main(Model model) {
		LocalDateTime now = LocalDateTime.now();
		//↑現在の日時を所得。LocalDateTime.now()は、現在の日時を取得するための静的メソッド
		String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		//↑日時を「年-月-日 時:分:秒」の形式にフォーマットする指定
		model.addAttribute("currentDateTime",formattedDateTime);
		// currentDateTime でフォーマットされた日時 formattedDateTimeを渡す
		return "main";
	}
	//名前はどこから所得？
	
	@GetMapping("/registration")
	public String registration(Model model) {
		return "registration";
		
	}
	//employeeControllerコピペしたもの↓　コピペしてテストするのも良いかもとのこと
	@PostMapping("/registration")
	public String registration(
		Model m,
		@RequestParam("name") String name,
		@RequestParam("age") String age,
		@RequestParam("pass") String pass
		) {
		m.addAttribute("name" ,name);
		m.addAttribute("age" ,age);
		m.addAttribute("pass" ,pass);
		return "confirm";
	}
	
	//登録処理
	
	@PostMapping("/createConfirm")  // こちらはそのままでOK
	public String createConfirm(
	        Model m,
	        @RequestParam("name") String name,
	        @RequestParam("age") String age,
	        @RequestParam("pass") String pass
	) {
	    // 確認処理
	    Employee employee = new Employee(name, Integer.parseInt(age), pass);
	    m.addAttribute("employee", employee);
	    return "createConfirm";
	}

}
