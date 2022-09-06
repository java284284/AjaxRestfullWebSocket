package _99_logger;

import java.security.SecureRandom;
import java.util.Formatter;

public class SecureRandomDemo {
	public static void main(String[] args) {
		byte[] iv = new byte[256 / 8]; 
		SecureRandom prng = new SecureRandom();
		prng.nextBytes(iv);
		
		Formatter formatter = new Formatter();
		for (byte b : iv){
			formatter.format("%02x", b);
		}
		System.out.println(formatter.toString());
	}
}
