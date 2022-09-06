package com.example.springws147.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.springws147.model.Employee;

@RestController
@SessionAttributes({"mary", "john" })
public class RestControllerDemo {
	@GetMapping("/rest123")
	public Employee demo(Model model) {
		Employee e = (Employee)model.getAttribute("mary");
//		return new Employee("Kitty", "台北市", 36900);   
		return e;   
	} 
}
