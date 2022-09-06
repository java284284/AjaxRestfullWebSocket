package com.example.springws147.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.springws147.model.Employee;

@Controller
@SessionAttributes({"mary", "john" })
public class HomeController {

	@GetMapping("/")
	public String index(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		Date d  = new Date();
		String createTime = sdf.format(d);
		model.addAttribute("now", createTime);
		Employee e = new Employee("Mary", createTime, 65000);
		model.addAttribute("mary", e);
		return "index";   
	}  // logic view name ==> "/WEB-INF/views/" + "index" + ".jsp"

}
