package ch09.security.jaas;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class CipherUtility {
	static String key = "KittySnoopyMicky";
	/** 
	 *   本方法可對字串message(Plaintext)加密，key為加密金鑰
	 *   傳回值為加密後的字串(Ciphertext)
	 *   
	 */
	public static String encryptString(String key, String message)
			throws Throwable {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); 
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
     	String encryptedString = DatatypeConverter.printBase64Binary(cipher.doFinal(message.getBytes()));
     	//String urlEncodedString = URLEncoder.encode(encryptedString,"UTF-8");
		return encryptedString;
	}
	/** 
	 *   本方法可對加密之字串(Ciphertext)解密，key為當初加密時的金鑰
	 *   傳回值為解密後的字串(Plaintext)
	 *   
	 */
	public static String decryptString(String key, String stringToDecrypt)
			throws Throwable {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		// String stringToDecrypt = URLDecoder.decode(stringToDecoded, "UTF-8");
		byte[] b = DatatypeConverter.parseBase64Binary(stringToDecrypt);
		String decryptedString = new String(cipher.doFinal(b));
		return decryptedString;
		
	}
	public static String getMD5Encoding(String str) {
		final StringBuffer buffer = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] digest = md.digest();
			
			for (int i = 0; i < digest.length; ++i) {
				final byte b = digest[i];
				final int value = (b & 0x7F) + (b < 0 ? 128 : 0);
				buffer.append(value < 16 ? "0" : "");
				buffer.append(Integer.toHexString(value));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		return buffer.toString();
	}
}
