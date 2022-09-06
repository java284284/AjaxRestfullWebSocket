package _01_cipher.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * --------------------------------------------------------
 * CipherUtils.java提供功能： 
 * 1 : 字串加密(對稱式加密)，encryptString(String key, String message, byte[] iv) 
 * 2 : 字串解密(對稱式解密)，decryptString(String key, String stringToDecrypt, byte[] iv)
 * key(金鑰): 		長度必須是16個位元組或24個位元組或32個位元組
 * message: 		要加密的字串
 * stringToDecrypt:	要解密的字串	 
 * 
 * 注意: 如果你的金鑰是24個位元組或32個位元組, 你必須要到下列網址宣誓你不是恐怖分子後，
 * 下載額外的壓縮檔，將其內的兩個jar檔複製到所使用之JVM的
 * ${java.home}/jre/lib/security/資料夾內，覆蓋掉原有的兩個jar檔(local_policy.jar與US_export_policy.jar)。
 * 
 * jdk6: http://www.oracle.com/technetwork/java/javase/downloads/jce-6-download-429243.html 
 * jdk7: http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html 
 * jdk8: http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html
 * 
 * Author:
 * 
 * @author S.C.Wang, apriori302@gmail.com
 *
 */
public class CipherUtils {
//	private static String transformationECB = "AES/ECB/PKCS5Padding";
	private static String transformationCBC = "AES/CBC/PKCS5Padding";
	public static String encryptString(String key, String message, byte[] iv)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
		// 呼叫Cipher.getInstance("AES/CBC/PKCS5Padding")取得Cipher物件，
		// 無論是加密或解密都會用到Cipher類別。此類別是Java Cryptographic Extension (JCE)框架
		// 的核心類別，呼叫此方法時必須傳入一個代表加解密運算的字串(稱為transformation)。
		// 此字串的格式必須是 "algorithm/mode/padding" or "algorithm"
		// 說明: 
		// algorithm :	
		// AES: The standard comprises three block ciphers, AES-128, AES-192 and AES-256, 
		// adopted from a larger collection originally published as Rijndael. 
		// Each of these ciphers has a 128-bit block size, with key sizes of 128, 
		// 192 and 256 bits, respectively
		// mode		 : EBC	 
		Cipher cipher = Cipher.getInstance(transformationCBC);
		// padding: 
		// http://www.cnblogs.com/midea0978/articles/1437257.html
		//
        // mode: https://en.wikipedia.org/wiki/Block_cipher_mode_of_operation
		// 
		// javax.crypto.spec.SecretKeySpec類別會根據一個『代表密碼的位元組陣列』來
		// 建構一個金鑰(javax.crypto.SecretKey)，此位元組陣列是由密碼(以字串型式存在)
		// 的getBytes()得到，如果採用AES演算法，位元組陣列的長度必須是16個位元組、
		// 24個位元組或32個位元組。本方法採用『AES』對稱式加密演算法。
		//
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
		// Cipher物件初始化時應說明進行加密(Cipher.ENCRYPT_MODE)
		// 或解密(Cipher.DECRYPT_MODE)，同時傳入金鑰secretKey。
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
		// cipher.doFinal:開始加密，傳回值為位元組陣列
		byte[] ba = cipher.doFinal(message.getBytes());
		// 對加密後得到的位元組陣列進行Base64編碼。
		// 任何形式的資料以Base64的方式編碼後就會轉為由A-Z, a-z, 0-9 與 + /
		// 等64個字元所組成的字串。
		String encryptedString = DatatypeConverter.printBase64Binary(ba);
		return encryptedString;
	}

	/**
	 * 本方法可對加密之字串(Ciphertext)解密，key為當初加密時的金鑰，傳回值為解密後的字串(Plaintext)
	 * 
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @param key
	 *            : 加密金鑰(即加密的密碼)，必須是16或24或32個位元組
	 * 
	 * @param stringToDecrypt
	 *            : 已加密的字串
	 * 
	 * @return 解密後的字串
	 * @throws InvalidAlgorithmParameterException 
	 */
	public static String decryptString(String key, String stringToDecrypt, byte[] iv)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

		// 取得Cipher物件
		Cipher cipher = Cipher.getInstance(transformationCBC);

		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
		// Cipher物件初始化時應說明進行加密(Cipher.ENCRYPT_MODE)或解密(Cipher.DECRYPT_MODE)，
		// 同時要傳入金鑰
		cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));

		// 先將加密的字串由BASE64的字串反轉為byte[]
		byte[] b = DatatypeConverter.parseBase64Binary(stringToDecrypt);
		// 呼叫cipher.doFinal(b)開始對參數b進行解密
		String decryptedString = new String(cipher.doFinal(b));

		return decryptedString;
	}
	// 本方法可對加密之字串(Ciphertext)解密，key為當初加密時的金鑰，傳回值為解密後的字串(Plaintext)
	// 無IV版本
	public static String encryptString(String key, String message) 
    {
	
	String encryptedString = "";
	try {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); 
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		encryptedString = DatatypeConverter.printBase64Binary(cipher.doFinal(message.getBytes()));
	} catch (InvalidKeyException e) {
		e.printStackTrace();
	} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	} catch (NoSuchPaddingException e) {
		e.printStackTrace();
	} catch (IllegalBlockSizeException e) {
		e.printStackTrace();
	} catch (BadPaddingException e) {
		e.printStackTrace();
	}
	return encryptedString;
	}
	/** 
	 *   本方法可對加密之字串(Ciphertext)解密，key為當初加密時的金鑰
	 *   傳回值為解密後的字串(Plaintext)
	 *   無IV版本
	 */
	public static String decryptString(String key, String stringToDecrypt)
			 {
		String decryptedString = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); 
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] b = DatatypeConverter.parseBase64Binary(stringToDecrypt);
			decryptedString = new String(cipher.doFinal(b));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return decryptedString;
	}	
	
	public static File encryptSecretFile(String key, File in, byte[] iv) {
		String encryptFilename = null;
		File out = null;
		try {
			String pathname = in.getAbsolutePath();
			String folder = pathname.substring(0,
					pathname.lastIndexOf(File.separator));
			String filename = pathname.substring(pathname
					.lastIndexOf(File.separator) + 1);
			encryptFilename = java.net.URLEncoder.encode(
					encryptString(key, filename, iv), "UTF-8");
			out = new File(folder, encryptFilename);
			encryptFile(key, in, out, iv);
		} catch (Exception ex) {
			System.out.println("encryptSecretFile, 發生例外: " + ex.getMessage());
			ex.printStackTrace();
		}
		return out;
	}

	public static File decryptSecretFile(String key, File in, byte[] iv) {
		String decryptFilename = null;
		File out = null;
		try {
			String pathname = in.getAbsolutePath();
			String folder = pathname.substring(0,
					pathname.lastIndexOf(File.separator));
			String filename = pathname.substring(pathname
					.lastIndexOf(File.separator) + 1);
			decryptFilename = decryptString(key,
					java.net.URLDecoder.decode(filename, "UTF-8"), iv);
			int n = decryptFilename.lastIndexOf(".");
			String newFilename = decryptFilename.substring(0, n) + "-1"
					+ decryptFilename.substring(n);
			out = new File(folder, newFilename);
			decryptFile(key, in, out, iv);
		} catch (Exception ex) {
			System.out.println("encryptSecretFile, 發生例外: " + ex.getMessage());
			ex.printStackTrace();
		}
		return out;
	}

	/**
	 * 本方法可對未加密的檔案in加密，加密後的資料寫入檔案out，key為加密金鑰
	 * 
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws IOException
	 * @throws InvalidAlgorithmParameterException 
	 */
	public static void encryptFile(String key, File in, File out, byte[] iv)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException, IOException {
		// 準備能進行加密與解密運算Cipher類別的物件。
		Cipher cipher = Cipher.getInstance(transformationCBC);
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
		try (
			InputStream is = new FileInputStream(in);
			OutputStream os = new FileOutputStream(out);
			CipherInputStream cis = new CipherInputStream(is, cipher);
		) {
		   doCopy(cis, os);
		} catch(IOException ex){
			if (ex instanceof FileNotFoundException) {
				System.out.println("來源檔不存在或目的檔無法寫入");
			} else {
			   System.out.println("encryptFile()發生例外: " + ex.getMessage());
			}
			throw new IOException(ex.getMessage());
		} 
	}

	/**
	 * 本方法可對加密的檔案in解密，解密後的資料寫入檔案out, key為當初加密時所用的金鑰
	 * 
	 * @throws InvalidKeyException
	 * @throws IOException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidAlgorithmParameterException 
	 */
	public static void decryptFile(String key, File in, File out, byte[] iv)
			throws InvalidKeyException, IOException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidAlgorithmParameterException {
		Cipher cipher = Cipher.getInstance(transformationCBC);
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
		
		cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
		try (InputStream is = new FileInputStream(in);
			 OutputStream os = new FileOutputStream(out);
			 CipherOutputStream cos = new CipherOutputStream(os, cipher);
		) {
			doCopy(is, cos);
		} catch (IOException ex) {
			System.out.println("encryptFile()發生例外: " + ex.getMessage());
		}
	}

	public static void doCopy(InputStream is, OutputStream os)
			throws IOException {
		byte[] bytes = new byte[8192];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			os.write(bytes, 0, numBytes);
		}
	}

	public static String getStringMD5(String message) {
		return getStringHash(message, "MD5");
	}

	public static String getStringSHA1(String message) {
		return getStringHash(message, "SHA1");
	}
	
	public static String getStringSHA256(String message) {
		return getStringHash(message, "SHA-256");
	}
	
	public static String getStringSHA384(String message) {
		return getStringHash(message, "SHA-384");
	}
	
	public static String getStringSHA512(String message) {
		return getStringHash(message, "SHA-512");
	}
	
	private static String getStringHash(String message, String algorithm) {
		final StringBuffer buffer = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(message.getBytes());
			byte[] digest = md.digest();

			for (int i = 0; i < digest.length; ++i) {
				byte b = digest[i];
				String s = Integer.toHexString(Byte.toUnsignedInt(b));
				s = s.length() < 2 ? "0" + s : "" + s;
				buffer.append(s);
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println("請檢查使用的演算法，演算法有誤");
			return null;
		}
		return buffer.toString();
	}

	
	
	public static String getFileSHA1(File file) {
		return getFileHash(file, "SHA1");
	}
	
	public static String getFileSHA256(File file) {
		return getFileHash(file, "SHA-256");
	}
	
	public static String getFileSHA384(File file) {
		return getFileHash(file, "SHA-384");
	}
	
	public static String getFileSHA512(File file) {
		return getFileHash(file, "SHA-512");
	}

	public static String getFileMD5(File file) {
		return getFileHash(file, "MD5");
	}

	private static String getFileHash(File file, String algorithm) {
		final StringBuffer buffer = new StringBuffer();
		try (
			FileInputStream fis = new FileInputStream(file);	
		){
			MessageDigest md = MessageDigest.getInstance(algorithm);
			byte[] b = new byte[8192];
			int len = 0;
			while ((len = fis.read(b)) != -1) {
				md.update(b, 0, len);
			}
			byte[] digest = md.digest();

			for (int i = 0; i < digest.length; ++i) {
				byte data = digest[i];
				String s = Integer.toHexString(Byte.toUnsignedInt(data));
				s = s.length() < 2 ? "0" + s : "" + s;
				buffer.append(s);
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println("請檢查使用的演算法，演算法有誤");
			return null;
		} catch (FileNotFoundException e) {
			System.out.println("檔案不存在，請檢查");
			return null;
		} 		
		catch (IOException e) {
			System.out.println("發生IO錯誤");
			return null;
		}
		return buffer.toString();
	}

	public static boolean fileCompare(File f1, File f2) throws IOException {
		System.out.println("開始比對...");
		try (FileInputStream fisp = new FileInputStream(f1);
				FileInputStream fisp2 = new FileInputStream(f2);) {
			long s, e;
			s = System.currentTimeMillis();
			if (fisp.available() != fisp2.available()) {
				System.out.println("比對不符, fisp.available()=" + fisp.available() + ", fisp2.available()=" + fisp2.available());
				return false;
			}
			byte[] b1 = new byte[81920];
			byte[] b2 = new byte[81920];
			int len;
			int total = 0;
			while ((len = fisp.read(b1)) != -1 && (len = fisp2.read(b2)) != -1) {
				total += len;
				if (!Arrays.equals(b1, b2)) {
					e = System.currentTimeMillis();
					System.out.println("比對不符, " + "需時:" + (e - s));
					System.out.println();
					return false;
				}
			}
			System.out.println("比對之位元組數=" + total);
			e = System.currentTimeMillis();
			System.out.println("完全相同, " + "需時:" + (e - s));
		}
		return true;
	}
    // -----------------------------------------------------------
	// RSA Encryption and Decryption  
	// 1. 產生由公鑰、私鑰所組成的KeyPair                   
	public static KeyPair genKeyPair() {
		KeyPair kp = null;
		try {
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(2048);
			kp = kpg.genKeyPair();
		} catch (NoSuchAlgorithmException ex) {
		    System.out.println(ex.getMessage());
		}
		return kp;
	}
	public static String encryptStringAsymmetric(Key pubKey, String message)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

		// 呼叫Cipher.getInstance("RSA")取得Cipher物件，
		// 無論是加密或解密都會用到Cipher類別。
		// 呼叫此方法時必須傳入一個代表加解密運算的字串。此字串的格式必須是:
		// "algorithm/mode/padding" or "algorithm"
		//
		Cipher cipher = Cipher.getInstance("RSA");

		// Cipher物件初始化時應說明進行加密(Cipher.ENCRYPT_MODE)或解密(Cipher.DECRYPT_MODE)，
		// 同時要傳入pubKey。
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);

		// cipher.doFinal:開始加密，傳回值為位元組陣列
		byte[] ba = cipher.doFinal(message.getBytes());

		// 對加密後得到的位元組陣列進行Base64編碼。
		// 任何形式的資料以Base64的方式編碼後就會轉為由A-Z, a-z, 0-9 與 + /
		// 等64個字元所組成的字串。
		String encryptedString = DatatypeConverter.printBase64Binary(ba);

		return encryptedString;
	}

	/**
	 * 本方法可對加密之字串(Ciphertext)解密，key為當初加密時的金鑰，傳回值為解密後的字串(Plaintext)
	 * 
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @param key
	 *            : 加密金鑰(即加密的密碼)，必須是16或24或32個位元組
	 * 
	 * @param stringToDecrypt
	 *            : 已加密的字串
	 * 
	 * @return 解密後的字串
	 * @throws InvalidAlgorithmParameterException 
	 */
	public static String decryptStringAsymmetric(Key priKey, String stringToDecrypt)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

		// 取得Cipher物件
		Cipher cipher = Cipher.getInstance("RSA");
		// Cipher物件初始化時應說明進行加密(Cipher.ENCRYPT_MODE)或解密(Cipher.DECRYPT_MODE)，
		// 同時要傳入金鑰
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		
		// 先將解密的字串由BASE64的字串反轉為byte[]
		byte[] b = DatatypeConverter.parseBase64Binary(stringToDecrypt);
		// 呼叫cipher.doFinal(b)開始對參數b進行解密
		String decryptedString = new String(cipher.doFinal(b));

		return decryptedString;
	}

	/**
	 * 本方法可對未加密的檔案in加密，加密後的資料寫入檔案out，key為非對稱式金鑰
	 * @throws InvalidAlgorithmParameterException 
	 * 
	 */
	public static void encryptFileAsymmetric(Key key, File in, File out, byte[] iv)
//	public static SecretKey encryptFileAsymmetric( File in, File out)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IOException, IllegalBlockSizeException, 
			BadPaddingException, InvalidAlgorithmParameterException {

//		// 1. 產生一個對稱式金鑰加密: sessionKey
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		SecretKey sessionKey = keyGen.generateKey();
//		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
		//
		// 2. 用公鑰來將sessionKey加密，加密後的sessionKey就必須私鑰才能解開
		Cipher rsaCipher = Cipher.getInstance("RSA");
		rsaCipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedSessionKey = rsaCipher.doFinal(sessionKey.getEncoded());
		System.out.println("encryptedSessionKey.length=" + encryptedSessionKey.length);
		// 
		// 3. 用未加密的sessionKey來對檔案加密
		Cipher cipher = Cipher.getInstance(transformationCBC);
		cipher.init(Cipher.ENCRYPT_MODE, sessionKey, new IvParameterSpec(iv));
		try (
			InputStream is = new FileInputStream(in);
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(out));
			CipherInputStream cis = new CipherInputStream(is, cipher);
		) {
		   System.out.println("encrypt len=" + encryptedSessionKey.length);
		   for (byte bb: encryptedSessionKey){
			   String s = Integer.toHexString(Byte.toUnsignedInt(bb));
			   s = (s.length() < 2 ? '0' + s : s);
			   System.out.print( s + " ");
		   }
		   System.out.println();
		   dos.writeInt(encryptedSessionKey.length);  // 寫出四個位元組的整數
		   dos.write(encryptedSessionKey);            // 將加密後的SessionKey寫入檔案。
		   doCopy(cis, dos);
		} catch(IOException ex){
			System.out.println("encryptFile()發生例外: " 
			       + ex.getMessage());
		} 
		//return sessionKey;
	}

	/**
	 * 本方法可對加密的檔案in解密，解密後的資料寫入檔案out, key為非對稱式金鑰
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws InvalidAlgorithmParameterException 
	 * 
	 */
	public static void decryptFileAsymmetric(Key key, File in, File out, byte[] iv)
			throws InvalidKeyException, IOException, NoSuchAlgorithmException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
		try (
		   DataInputStream dis = new DataInputStream(
				                     new FileInputStream(in));
		) {
		   int len = dis.readInt();
		   byte[] b = new byte[len];
		   dis.read(b);
		   for (byte bb: b){
			   String s = Integer.toHexString(Byte.toUnsignedInt(bb));
			   s = (s.length() < 2 ? '0' + s : s);
			   System.out.print( s + " ");
		   }
		   System.out.println();
           // 取得Cipher物件
		   Cipher rsaCipher = Cipher.getInstance("RSA");
			// Cipher物件初始化時應說明進行加密(Cipher.ENCRYPT_MODE)或解密(Cipher.DECRYPT_MODE)，
			// 同時要傳入金鑰
		   rsaCipher.init(Cipher.DECRYPT_MODE, key);
			// 呼叫cipher.doFinal(b)開始對參數b進行解密
		   byte[] ba = rsaCipher.doFinal(b);
		   SecretKey secretKey = new SecretKeySpec(ba, 0, ba.length, "AES");
		   Cipher cipher = Cipher.getInstance(transformationCBC);
		   cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
		   try(
		      OutputStream os = new FileOutputStream(out);
		      CipherOutputStream cos = new CipherOutputStream(os, cipher);
              
		   ){
			   doCopy(dis, cos);
		   }
		} catch(IOException ex){
			System.out.println("decryptFileAsymmetric()發生例外: " 
		       + ex.getMessage());
		}
	}
	public static void main(String[] args) {
		File file = new File("D:\\Downloads\\Sil\\apache-tomcat-9.0.12-windows-x64.zip");
		String sha512 = getFileSHA512(file);
		System.out.println(sha512);
		
		
		
	}
}
// c16def527e9d7e8b894f9b534aedb08c2ea66720a8b3eeb34112f7b050880b24812abd9576c120d19964d4ae235e99d0f679872e2b2521386bc94ab6a15e1f70
// c16def527e9d7e8b894f9b534aedb08c2ea66720a8b3eeb34112f7b050880b24812abd9576c120d19964d4ae235e99d0f679872e2b2521386bc94ab6a15e1f70
