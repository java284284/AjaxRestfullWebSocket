package ch00;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneDemo2 {

	public static void main(String[] args) {
		TimeZone tz2 = TimeZone.getTimeZone("America/New_York");
		TimeZone.setDefault(tz2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date d = new Date(0);
		System.out.println(sdf.format(d));
		
		d = new Date();
		System.out.println(sdf.format(d));
		
		
	}

}
