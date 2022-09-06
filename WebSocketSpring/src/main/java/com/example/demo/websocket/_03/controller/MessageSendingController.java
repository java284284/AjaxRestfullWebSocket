package com.example.demo.websocket._03.controller;

import java.util.Date;
import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo.websocket._03.model.HelloMessage;

@Controller
public class MessageSendingController {

	@Autowired
	MyTimerTask  timeTask;
	
	@MessageMapping("/queryTime")
	@SendTo("/topic/greetings")
	public void queryTime(HelloMessage message) throws Exception {
		Timer timer = new Timer();
		timeTask.setTimer(timer);
		timer.schedule(timeTask, new Date(), 1000);
	}

}
