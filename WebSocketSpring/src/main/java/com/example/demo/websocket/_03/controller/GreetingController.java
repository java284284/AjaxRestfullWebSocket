package com.example.demo.websocket._03.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.example.demo.websocket._03.model.Greeting;
import com.example.demo.websocket._03.model.HelloMessage;

@Controller
public class GreetingController {
    
	@MessageMapping("/hello")  //  if a message is sent to the /hello destination, the greeting() method is called.
  	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {   // HelloMessage: payload of the message
		Thread.sleep(1000);    // simulated delay
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}
}
