package ch00;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

public class TimeZoneDemo {

	public static void main(String[] args) {
		String[] sa =  TimeZone.getAvailableIDs();
		Arrays.sort(sa);
		for(String s: sa) {
			System.out.println(s);
		}
		System.out.println("-----------------");
		List<String> list = Arrays.asList(sa);
		Collections.sort(list);
		for(String s: list) {
			System.out.println(s);
		}
	}

}
