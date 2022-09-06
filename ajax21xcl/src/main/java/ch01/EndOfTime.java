package ch01;

import java.util.GregorianCalendar;

public class EndOfTime {

	public static void main(String[] args) {
		System.out.println(Long.MAX_VALUE);
		long seconds2038 = Integer.MAX_VALUE;  // 2147483647
		long seconds = Long.MAX_VALUE;
		int year = 1970;
		while (true) {
			long tmp = millisSecondsInYear(year);
			if (seconds > tmp) {
				seconds -= tmp;
			} else {
				break;
			}
			if (year % 100000000 == 0)
				System.out.println("year=" + year + ", seconds=" + seconds);
			year++;
		}
		System.out.println("year=" + year);
		System.out.println("--------------------------------");
		int month = 1;
		while (true) {
			long tmp = millisSecondsInMonth(year, month) ;
			if (seconds > tmp) {
				seconds -= tmp;
			} else {
				break;
			}
			
			month++;
		} 
		System.out.println("month=" + month);
		System.out.println("--------------------------------");
		int day = 1;
		while (true) {
			if (seconds > 86400 * 1000) {
				seconds -= 86400 * 1000;
			} else {
				break;
			}
			day++;
		} 
		System.out.println("day=" + day);
		
		System.out.println("--------------------------------");
		int hour = 0;
		while (true) {
			if (seconds > 3600 * 1000) {
				seconds -= 3600 * 1000;
			} else {
				break;
			}
			hour++;
		} 
		System.out.println("hour=" + hour);
		
		System.out.println("--------------------------------");
		int minute = 0;
		while (true) {
			if (seconds > 60 * 1000) {
				seconds -= 60 * 1000;
			} else {
				break;
			}
			minute++;
		} 
		System.out.println("minute=" + minute);
		System.out.println("second=" + seconds / 1000);
		System.out.println("millisecond=" + seconds % 1000);
		
		
	}
	
	
	public static long millisSecondsInMonth(int year, int month) {
		int [] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		GregorianCalendar gc = new GregorianCalendar();
		if (gc.isLeapYear(year)) {
			days[2] = 29; 
		} else {
			days[2] = 28;
		}
		return days[month] * 86400 * 1000L;
		
		
	}
	
    public static long millisSecondsInYear(int year) {
		GregorianCalendar gc = new GregorianCalendar();
//		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
//			System.out.println(year + " is leap year.");
//		}
		if (gc.isLeapYear(year)) {
			return 366 * 86400 * 1000L;
		} else {
			return 365 * 86400 * 1000L;
		}
	}

}
