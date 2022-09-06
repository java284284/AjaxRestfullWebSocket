package _00_init.misc;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;

import _01_cipher.util.CipherUtils;

public class EncrypStringToFile {

	public static void main(String[] args) throws Exception {
		String plainText = "今年第14號颱風莫蘭蒂在今天下午2時形成，氣象局說，輕颱莫蘭蒂距離台灣約2100公里，正以每小時20公里速度向西北西移動，13日晚上到15日是颱風最接近台灣的時候，中秋連假天氣將受影響。";
		String key = "KittySnoopy12345";
		byte[] bkey = key.getBytes();
		byte[] iv = new byte[16];
        SecureRandom srnd = new SecureRandom();
		srnd.nextBytes(iv);
		BigInteger bi_key = new BigInteger(bkey);
		BigInteger bi_iv  = new BigInteger(iv);

		BigInteger temp = bi_key.xor(bi_iv);
//		System.out.println("bikey=" + bi_key);
//		System.out.println(" temp=" + temp);
//		System.out.println("   bi=" + bi_iv);
		String secretText = CipherUtils.encryptString(key, plainText, iv);
//		System.out.println(temp.toByteArray().length);
//		System.out.println(bi.toByteArray().length);
		try (FileOutputStream fos = new FileOutputStream("d:\\eeit89_lad01.txt");) {
			fos.write(temp.toByteArray());
			fos.write(bi_iv.toByteArray());
			fos.write(secretText.getBytes());
		}

	}

}
