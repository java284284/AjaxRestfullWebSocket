package _00_init;


import java.security.SecureRandom;

import _01_cipher.util.CipherUtils;

public class CipherMain_Symmetric  {
	public static void main(String[] args) throws Exception  {
        String key = "kittymickysnoopy";
		byte[] iv = new byte[128 / 8];   
		SecureRandom srnd = new SecureRandom();
		srnd.nextBytes(iv);
		
//// 範例一：對字串加密、解密		
//		System.out.println("\n範例一：對字串加密、解密");
//		encrypt$DecryptStringDemo(key, "今年第14號颱風莫蘭蒂在今天下午2時形成，氣象局說，輕颱莫蘭蒂距離台灣約2100公里，正以每小時20公里速度向西北西移動，13日晚上到15日是颱風最接近台灣的時候，中秋連假天氣將受影響。");
//// 範例二：對檔案加密、解密
//        System.out.println("\n範例二：對檔案加密、解密 (AES-256 Block size, AES/CBC/PKCS5Padding)");		
//		String name1 = "C:\\_JSP\\jdk1.8\\jre\\lib\\rt.jar";
//		String name2 = name1.substring(0, name1.lastIndexOf(".")) + ".enc";
//		String name3 = name1.substring(0, name1.lastIndexOf(".")) + ".dec";
//		File f1 = new File(name1);
//		File f2 = new File(name2);
//		File f3 = new File(name3);
//		CipherUtils.encryptFile(key, f1, f2, iv);
//		CipherUtils.decryptFile(key, f2, f3, iv);
//		CipherUtils.fileCompare(f1, f3);
		
//// 範例三：計算字串的MD5與SHA1的Hash值	
	    System.out.println("\n範例三：計算字串的MD5與SHA1的Hash值");
		String s1 = "mr456";
		System.out.println("MD5 ->" + CipherUtils.getStringMD5(s1));
		System.out.println("SHA1->" + CipherUtils.getStringSHA1(s1));		

//// 範例四：計算檔案的MD5與SHA1的Hash值		
//	    System.out.println("\n範例四：計算檔案的MD5與SHA1的Hash值");		
//		String s2 = "C:\\Users\\Student\\Downloads\\apache-tomcat-8.0.38-windows-x64.zip";
//		File file_2 = new File(s2);
//		System.out.println("MD5 ->" + CipherUtils.getFileMD5(file_2));
//		System.out.println("SHA1->" + CipherUtils.getFileSHA1(file_2));
//      範例五：對檔案、檔名加密、解密			
//	    System.out.println("\n範例五：對檔案、檔名加密、解密");		
//		String path = "C:\\_JSP\\jdk1.8\\jre\\lib\\rt.jar";
//		File file = new File(path);
//		File encryptFile = CipherUtils.encryptSecretFile(key, file, iv);
//		System.out.println("encryFile=" + encryptFile);
//		File decryptFile = CipherUtils.decryptSecretFile(key, encryptFile, iv);
//		CipherUtils.fileCompare(decryptFile, file);
	}

	// 本方法展示如何對字串加密與如何對字串解密
	public static void encrypt$DecryptStringDemo(String key, String plainText) 
		throws Exception {
		// AES只有三種Block的長度，AES-128、AES-192、AES-256，AES的key的長度一定是128位元
		byte[] iv = new byte[128 / 8];   
		SecureRandom srnd = new SecureRandom();
		srnd.nextBytes(iv);
		//			
		// encryptString(key, plainText, iv) : 將明文轉換為密文
		String cipherText = CipherUtils.encryptString(key, plainText, iv);
		// decryptString(key, cipherText, iv) : 將密文還原為明文
		String decrytString = CipherUtils.decryptString(key, cipherText, iv);
		
		System.out.println("原來的字串:" + plainText);
		System.out.println("加密後字串:" + cipherText);
		
		System.out.println("解密後字串:" + decrytString);
		System.out.println("字串相等否:" + plainText.equals(decrytString));
//		System.out.println("任何資料，經過MD5運算後會得到16個位元組的陣列(以16進位印出會得到32個字元)");
//		System.out.println("經MD5 hash:" + CipherUtils.getStringMD5(cipherText));
	}
}