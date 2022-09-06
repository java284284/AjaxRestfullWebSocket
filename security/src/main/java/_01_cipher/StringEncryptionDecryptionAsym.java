package _01_cipher;

import java.security.KeyPair;
import java.security.SecureRandom;

import _01_cipher.util.CipherUtils;

public class StringEncryptionDecryptionAsym {
	public static void main(String[] args) {
		String plainText = "美國總統(川普)的老婆拍過裸照^^";
        // 產生一對公鑰與私鑰(keyPair)
		KeyPair keyPair = CipherUtils.genKeyPair();
		// 產生Initialization Vector
		byte[] iv = new byte[128 / 8];
		SecureRandom srnd = new SecureRandom();
		srnd.nextBytes(iv);
		try {
			System.out.println("---------用公鑰加密，用私鑰解密------------");
			// 用公鑰加密，傳回值為加密後的字串
			String cipherText = CipherUtils.encryptStringAsymmetric(
					keyPair.getPublic(), plainText);
			// 用私鑰解密，傳回值為還原後的字串
			String decrytString = CipherUtils.decryptStringAsymmetric(
					keyPair.getPrivate(), cipherText);
			System.out.println("原來的字串:" + plainText);
			System.out.println("加密後字串:" + cipherText);

			System.out.println("解密後字串:" + decrytString);
			System.out.println("字串相等否:" + plainText.equals(decrytString));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
