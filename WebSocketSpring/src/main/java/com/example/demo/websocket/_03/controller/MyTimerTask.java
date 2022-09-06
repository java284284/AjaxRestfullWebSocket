package com.example.demo.websocket._03.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.websocket._03.model.Greeting;

@Component
public class MyTimerTask extends TimerTask {

	@Autowired
	private SimpMessagingTemplate template;

	Timer timer;

	int count = 0;

	public MyTimerTask() {
		
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	@Override
	public void run() {
		count++;
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		template.convertAndSend("/topic/greetings", new Greeting(sdf.format(d)));
		if (count == 5) {
			timer.cancel();
			timer.purge();
			timer = null;
			template.convertAndSend("/topic/greetings", new Greeting("計時結束..."));
			return;
		}
	}

}