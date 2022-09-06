package _00_init.misc;

import java.security.SecureRandom;

public class XORDemo2 {

	public static void main(String[] args) throws Exception {
		String name = "abc";
		byte[] b1 = name.getBytes();
		System.out.println(toScreen(b1));
		byte[] b2 = name.getBytes("unicode");
		System.out.println(toScreen(b2));
		byte[] b3 = name.getBytes("big5");
		System.out.println(toScreen(b3));
		byte[] b4 = name.getBytes("utf-8");
		System.out.println(toScreen(b4));
	}
    public static String toScreen(byte[] ba){
    	StringBuffer buffer = new StringBuffer();
    	for (int i = 0; i < ba.length; ++i) {
			byte b = ba[i];
			String s = Integer.toHexString(Byte.toUnsignedInt(b));
			s = s.length() < 2 ? "0" + s : "" + s;
			buffer.append(s + " ");
		}
    	return buffer.toString();
    }
}
