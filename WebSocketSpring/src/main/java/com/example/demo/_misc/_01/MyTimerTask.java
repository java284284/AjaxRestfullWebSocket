package com.example.demo._misc._01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
	
	Timer timer;

	int count = 0;

	public MyTimerTask(Timer timer) {
		this.timer = timer;
	}

	@Override
	public void run() {
		count++;
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(d));
		if (count == 5) {
			timer.cancel();
			timer.purge();
			return;
		}
	}

}
