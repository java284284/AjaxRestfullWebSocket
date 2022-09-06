package _99_logger;

import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AES_DEFAULT {  
	 public static byte[] Encrypt(SecretKey secretKey, String msg) throws Exception  
	 {  
	  Cipher cipher = Cipher.getInstance("AES"); //: 等同 AES/ECB/PKCS5Padding
	  cipher.init(Cipher.ENCRYPT_MODE, secretKey); 
	  System.out.println("AES_DEFAULT IV:" + cipher.getIV());
	  System.out.println("AES_DEFAULT Algoritm:"+cipher.getAlgorithm());
	  byte[] byteCipherText = cipher.doFinal(msg.getBytes());  
	  System.out.println("加密結果的Base64編碼：" + Base64.getEncoder().encodeToString(byteCipherText));
	  return byteCipherText;  
	 }  

	 public static byte[] Decrypt(SecretKey secretKey, byte[] cipherText) throws Exception  
	 {  
	  Cipher cipher = Cipher.getInstance("AES"); 
	  cipher.init(Cipher.DECRYPT_MODE, secretKey);  
	  byte[] decryptedText = cipher.doFinal(cipherText);  
	  String strDecryptedText = new String(decryptedText);
	  System.out.println("解密結果：" + strDecryptedText);
	  return decryptedText;  
	 }  

	 public static void main(String args[]) throws Exception{
	  KeyGenerator keyGen = KeyGenerator.getInstance("AES");
	  keyGen.init(128, new SecureRandom( ) );
	  SecretKey secretKey = keyGen.generateKey();
	  byte[] iv = new byte[128 / 8]; 
	  SecureRandom prng = new SecureRandom();
	  prng.nextBytes(iv);

	  byte[] cipher = AES_DEFAULT.Encrypt(secretKey, "I am PlainText!!");
	  AES_DEFAULT.Decrypt(secretKey, cipher);  
	 }
	} 