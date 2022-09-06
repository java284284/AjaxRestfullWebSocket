package com.example.demo._misc._01;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new MyTimerTask(timer);
		timer.schedule(task, new Date(), 1000);
	}

}
