package ajax17._01.model;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class TimeReportBean {
	TimeZone timeZone;
	String pattern = "yyyy-MM-dd HH:mm:ss";

	public TimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}
	public String getTime(){
		SimpleDateFormat  sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(timeZone);
		return sdf.format(new java.util.Date());
	}
	
}
