package com.example.demo;
// 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.init.InitialListener;

@SpringBootApplication
public class WebSocket01Application {

	public static void main(String[] args) {
		SpringApplication.run(WebSocket01Application.class, args);
	}
	
	// 啟動一個實作ServletContextListener介面的Bean, Tomcat會在啟動
	// 本應用系統時，自動執行它的contextInitialized()方法。
	@Bean
	public InitialListener initialListener() {
	   return new InitialListener();
	}

}
