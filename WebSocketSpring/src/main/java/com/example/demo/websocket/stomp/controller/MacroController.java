package com.example.demo.websocket.stomp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.websocket.stomp.model.Shout;

@Controller
public class MacroController {
	public static Logger logger = LoggerFactory.getLogger(MacroController.class);
	
	@MessageMapping("/macro")
	public Shout handleShout(Shout incoming) {
		logger.info("收到訊息: " + incoming.getMessage());
		return new Shout("妳好!!!");
	}
}
