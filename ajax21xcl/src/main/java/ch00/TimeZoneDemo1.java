package ch00;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneDemo1 {

	public static void main(String[] args) {
		Date d = new Date(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(d));
		
		TimeZone tz1 = TimeZone.getTimeZone("Asia/Taipei");
		//TimeZone.setDefault(tz1);
		sdf.setTimeZone(tz1);
		System.out.println("台北: " + sdf.format(d));
		
		TimeZone tz2 = TimeZone.getTimeZone("GMT");
		//TimeZone.setDefault(tz2);
		sdf.setTimeZone(tz2);
		System.out.println("GMT: " + sdf.format(d));
		
		TimeZone tz3 = TimeZone.getTimeZone("Australia/Perth");
		//TimeZone.setDefault(tz3);
		sdf.setTimeZone(tz3);
		System.out.println("伯斯: " + sdf.format(d));
		
	}

}
