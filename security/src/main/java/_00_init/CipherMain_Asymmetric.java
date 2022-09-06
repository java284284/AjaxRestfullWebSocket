package _00_init;

import java.io.File;
import java.security.KeyPair;
import java.security.SecureRandom;

import _01_cipher.util.CipherUtils;

public class CipherMain_Asymmetric  {

	public static void main(String[] args) throws Exception  {
		KeyPair keyPair = CipherUtils.genKeyPair();
		byte[] iv = new byte[128 / 8];   
		SecureRandom srnd = new SecureRandom();
		srnd.nextBytes(iv);
//		// 範例一：對字串加密、解密		
//		System.out.println("範例一：對字串加密、解密");
//		encrypt$DecryptStringAsymmetricDemo(keyPair, "行政院兆豐案督導小組決議向蔡友才啟動民事求償");
		// 範例二：對檔案、檔名加密、解密			
	    System.out.println("範例二：對檔案加密、解密");   		
		String in = "C:\\_JSP\\jdk1.8\\jre\\lib\\rt.jar";
		String out = "C:\\_JSP\\jdk1.8\\jre\\lib\\rt.asyenc";
		String dec = "C:\\_JSP\\jdk1.8\\jre\\lib\\rt.asydec";
//		String in = "C:\\_JSP\\mysql\\my.ini";
//		String out = "C:\\_JSP\\mysql\\my.asyenc";
//		String dec = "C:\\_JSP\\mysql\\my.asydec";
		File filein = new File(in);
		File fileout = new File(out);
		File filedec = new File(dec);
		CipherUtils.encryptFileAsymmetric(keyPair.getPublic(), filein, fileout, iv);
//		SecretKey key1 = CipherUtils.encryptFileAsymmetric(filein, fileout);
		System.out.println(fileout.length());
		System.out.println("--------------------");
		//CipherUtils.decryptFileAsymmetric(keyPair.getPrivate(), fileout, filedec, key1);
		CipherUtils.decryptFileAsymmetric(keyPair.getPrivate(), fileout, filedec, iv);
//		CipherUtils.decryptFileAsymmetric(fileout, filedec, key1);
		CipherUtils.fileCompare(filedec, filein);
	}

	// 本方法展示如何對字串加密與如何對字串解密
	public static void encrypt$DecryptStringAsymmetricDemo(KeyPair kp, String plainText) 
			throws Exception {
		// encryptString(key, plainText) : 將明文轉換為密文
		String cipherText = CipherUtils.encryptStringAsymmetric(kp.getPublic(), plainText);
		// decryptString(key, cipherText) : 將密文還原為明文
		String decrytString = CipherUtils.decryptStringAsymmetric(kp.getPrivate(), cipherText);
		System.out.println("---------用公鑰加密，用私鑰解密------------");
		System.out.println("原來的字串:" + plainText);
		System.out.println("加密後字串:" + cipherText);
		
		System.out.println("解密後字串:" + decrytString);
		System.out.println("字串相等否:" + plainText.equals(decrytString));
	}
}