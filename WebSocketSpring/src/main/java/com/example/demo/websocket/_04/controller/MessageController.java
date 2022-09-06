package com.example.demo.websocket._04.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.example.demo.websocket._03.model.Greeting;
import com.example.demo.websocket._04.model.Message;
import com.example.demo.websocket._04.model.OutputMessage;

@Controller
public class MessageController {
	
	@Autowired
	private SimpMessagingTemplate template;

	@Scheduled(fixedRate = 5000)
	public void greet() {
	    template.convertAndSend("/topic/greetings", new Greeting("Bufff!"));
	}
	
	
	@MessageMapping("/chat")
	@SendTo({"/topic/messages"})
	public  OutputMessage processMessage(Message message) {
		String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
		return new OutputMessage(message.getFrom(), message.getText(), time);
	}
	
	@MessageMapping("/chat/{chatId}")
	@SendTo({"/topic/messages"})
	public  OutputMessage processChatRoomMessage(Message message) {
		String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
		return new OutputMessage(message.getFrom(), message.getText(), time);
	}
	
	
	
}
