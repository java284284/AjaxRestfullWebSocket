package _00_init.misc;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.SecureRandom;

import _01_cipher.util.CipherUtils;

public class DecrypStringFromFile {

	public static void main(String[] args) throws Exception {
		byte[] b1 = new byte[16];
		byte[] b2 = new byte[16];
		try (FileInputStream fis = new FileInputStream("d:\\eeit89_lad01.txt");) 
		{
			fis.read(b1);
			fis.read(b2);
			int available = fis.available();
			System.out.println("1.還剩多少?=" + fis.available() );
			byte[] left = new byte[available];	
			fis.read(left);
			System.out.println("2.還剩多少?=" + fis.available() );
			BigInteger temp = new BigInteger(b1);
			
			BigInteger bi_iv  = new BigInteger(b2);
			
			BigInteger bi_key = temp.xor(bi_iv);
			byte[]  bkey = bi_key.toByteArray();
			byte[]  iv = bi_iv.toByteArray();
			String key = new String(bkey);
			System.out.println(key);
			String stringToDecrypt = new String(left);
			String original  = CipherUtils.decryptString(key, stringToDecrypt, iv);
			System.out.println("解密後的字串: " + original);
			
		}
		
		

	}

}
