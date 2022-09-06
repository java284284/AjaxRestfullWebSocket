package _01_cipher;

import java.security.SecureRandom;

import _01_cipher.util.CipherUtils;

public class StringEncryptionDecryption {
	public static void main(String[] args) {
		String key = "kittymickysnoopy"; // 對稱式金鑰
		byte[] iv = new byte[128 / 8]; // 初始向量
		SecureRandom srnd = new SecureRandom();
		srnd.nextBytes(iv);
		String plainText = "美國總統(川普)的老婆拍過裸照";
		String cipherText = "";
		String decryptedString = "";
		try {
			// encryptString(key, plainText, iv) : 將明文轉換為密文
			cipherText = CipherUtils.encryptString(key, plainText, iv);
			// decryptString(key, cipherText, iv) : 將密文還原為明文
			decryptedString = CipherUtils.decryptString(key, cipherText, iv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("原始字串: " + plainText);
		System.out.println("加密字串: " + cipherText);
		System.out.println("解密字串: " + decryptedString);
	}
}
