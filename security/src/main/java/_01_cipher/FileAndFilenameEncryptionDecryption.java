package _01_cipher;

import java.io.File;
import java.security.SecureRandom;

import _01_cipher.util.CipherUtils;

public class FileAndFilenameEncryptionDecryption {
	public static void main(String[] args) {
		// 加密用的對稱式金鑰
		String key = "kittymickysnoopy";
		// 準備IV
		byte[] iv = new byte[128 / 8];
		SecureRandom srnd = new SecureRandom();
		srnd.nextBytes(iv);
		String path = "‪C:\\_SpringBoot\\jdk11\\lib\\ct.sym";
		try {
			File file = new File(path);
			System.out.println("開始加密..." );
			File encryptFile = CipherUtils.encryptSecretFile(key, file, iv);
			System.out.println("加密後的檔案=" + encryptFile);
			System.out.println("開始解密..." );
			File decryptFile = CipherUtils.decryptSecretFile(key, encryptFile, iv);
			CipherUtils.fileCompare(decryptFile, file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
