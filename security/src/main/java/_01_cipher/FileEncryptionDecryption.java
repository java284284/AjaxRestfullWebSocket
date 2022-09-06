package _01_cipher;

import java.io.File;
import java.security.SecureRandom;

import _01_cipher.util.CipherUtils;

public class FileEncryptionDecryption {
	public static void main(String[] args) {
		// 加密用的對稱式金鑰
		String key = "kittymickysnoopy";
		// 準備IV
		byte[] iv = new byte[128 / 8];
		SecureRandom srnd = new SecureRandom();
		srnd.nextBytes(iv);
		// name1: 需加密之檔案的檔名
		String name1 = "tomcatUtil.zip";
		// name2: 加密後之檔案的檔名
		String name2 = name1.substring(0, name1.lastIndexOf(".")) + ".enc";
		// name3: 解密後之檔案的檔名，其內容應該與加密前之檔案的內容完全相同
		String name3 = name1.substring(0, name1.lastIndexOf(".")) + ".dec";
		File f1 = new File(name1); // f1: 需加密之檔案的File物件
		File f2 = new File(name2); // f2: 加密後之檔案的File物件
		File f3 = new File(name3); // f3: 解密後之檔案的File物件
		try {
			// 開始對f1對應的檔案加密，加密的結果存放在f2對應的檔案內
			CipherUtils.encryptFile(key, f1, f2, iv);
			// 開始對f2對應的檔案解密，解密的結果存放在f3對應的檔案內
			CipherUtils.decryptFile(key, f2, f3, iv);
			// 比對f1與f3所對應的檔案
			CipherUtils.fileCompare(f1, f3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
