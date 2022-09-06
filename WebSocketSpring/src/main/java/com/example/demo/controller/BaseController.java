package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/index01")
	public String basicws() {
		return "_01_basicws";
	}
	
	@GetMapping("/index02")
	public String stompws2() {
		return "_02_basicsockjs";
	}
	
	@GetMapping("/index03")
	public String stompws3() {
		return "_03_stomp_springexample";
	}
	
	@GetMapping("/index04")
	public String stompws4() {
		return "_04_stompws2";
	}
	
	@GetMapping("/index05")
	public String stompws5() {
		return "_05_stompbael";
	}

}
