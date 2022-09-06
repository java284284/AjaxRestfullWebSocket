package _01_cipher;

import java.io.File;

import _01_cipher.util.CipherUtils;

public class CalculateFileHashValue {

	public static void main(String[] args) {
		System.out.println("計算檔案的MD5與SHA1的Hash值");		
		String s1 = "C:\\_JSP\\eclipse\\eclipse.exe";
		File file_1 = new File(s1);
		System.out.println("MD5->" + CipherUtils.getFileMD5(file_1));
		System.out.println("SHA1->" + CipherUtils.getFileSHA1(file_1));
		System.out.println("SHA256->" + CipherUtils.getFileSHA256(file_1));
		System.out.println("SHA384->" + CipherUtils.getFileSHA384(file_1));
		System.out.println("SHA512->" + CipherUtils.getFileSHA512(file_1));
	}
}
