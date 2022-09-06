package _00_init.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class CipherExample {
    
	public static void main(String[] args) throws Throwable {
		
		System.out.println("Case 1 : 字串加密與解密，請參考encrypt$DecryptStringDemo()");
		String key = "12345678GarfieldKittyMickySnoopy";
		String plainText = "條理總是出現在思緒沉澱之後，感謝分享。";
		encrypt$DecryptStringDemo(key, plainText);
		// --------------------------------------------------------		
		System.out.println();
		System.out.println("Case 2 : 檔案加密與解密");
		// Case 2 : 檔案加密與解密
		// 來源檔的路徑
        String path = "D:\\Source\\jdk-8u40-windows-x64.exe";
        File f = new File(path);
        if (!f.exists()){
        	System.out.println(path + "不存在，請將變數path更換一個存在之檔案的路徑...");
        	return;
        }
        // 取出資料夾與檔案
        String dir = path.substring(0, path.lastIndexOf("\\"));
        String filename = path.substring(path.lastIndexOf("\\")+1);
        // 檔名也加密，因為有些檔案的檔名會透露機密
        filename = URLEncoder.encode(encryptStringECB(key, filename), "UTF-8");
        
        // 加密後的檔案名稱: 原來的主檔名之後，加上".enc"
        String pathEncryp = dir + "\\" + filename + ".enc";
        
        // 解密(還原)後的檔案名稱: 原來的主檔名之後，加上".dec"，不用原檔名，以免蓋掉原檔案        
        String pathDecryp = dir + "\\" + filename + ".dec";
		
		FileInputStream fisp = new FileInputStream(path);
		FileOutputStream fosc = new FileOutputStream(pathEncryp);
		// 開始對來源檔(以fisp物件表示)加密，加密後的輸出檔為(以fosc物件表示)
		System.out.println("對" + path + "進行加密");
		System.out.println("加密後輸出檔為:" + pathEncryp);
		encryptStream(key, fisp, fosc);  // 開始加密
		System.out.println();
		// -----------------------------------------------
		// 現在進行解密，以先前加密後的檔案做為輸入檔來進行解密
		//
		FileInputStream fisc = new FileInputStream(pathEncryp);
		FileOutputStream fosp = new FileOutputStream(pathDecryp);
		System.out.println("對" + pathEncryp + "進行解密");
		System.out.println("解密後的檔案為:" + pathDecryp);
		decryptStream(key, fisc, fosp);
	    // -----------------------------------------------
		// 最後進行比對：加密+解密的檔案(*.dec)與原始檔比對。
		fisp = new FileInputStream(path);
		FileInputStream fisp2 = new FileInputStream(pathDecryp);
		
		if (fileCompare(fisp, fisp2)){
			System.out.println("兩檔案相等");
		} else {
			System.out.println("兩檔案不相等");
		}
	}
	//--------------------------------------------------------------------
	public static void restoreFile(String key, String path) throws Throwable{
		InputStream is;
		OutputStream os;
        String dir = path.substring(0, path.lastIndexOf("\\"));
        String filename = path.substring(path.lastIndexOf("\\")+1, path.lastIndexOf("."));
        filename = URLDecoder.decode(filename, "UTF-8");
        filename = decryptStringECB(key, filename);
        is = new FileInputStream(path);
        os = new FileOutputStream(dir+"\\another_" + filename);
        decryptStream( key, is, os);
	}
	// --------------------------------------------------------------------
	//  本方法展示如何對字串加密與如何對字串解密
	public static void encrypt$DecryptStringDemo(String key, String plainText) throws Throwable {
		//  encryptString(key, plainText)	: 將明文轉換為密文		
		String cipherText = encryptStringECB(key, plainText);
		//  decryptString(key, cipherText)	: 將密文還原為明文		
		String decrytString = decryptStringECB(key, cipherText);
		System.out.println("加密後:" + cipherText);
		System.out.println("解密後:" + decrytString);
		System.out.println("原字串:" + plainText );
		
		
	}
	/**
	 * 本方法可對字串message(Plaintext, 明文)加密，然後傳回加密後的字串 
	 * (Ciphertext, 密文)。
	 * 
	 * @param key
	 *            : 加密金鑰(即加密的密碼)，必須是16或24或32個位元組
	 * @param message
	 *            : 明文，即要加密的字串
	 * @return 加密後的
	 */
	public static String encryptStringECB(String key, String message)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		//
		// 抽象類別Cipher為JCE(Java Cryptographic Extension)架構的核心類別。
		// 程式必須呼叫Cipher類別的getInstance()方法來產生此類別的物件，無論是
		// 加密或解密都會用到此類別。
		// 呼叫此方法時必須傳入一個代表加密運算的字串。此字串的格式必須是:
		// "algorithm/mode/padding" or "algorithm"
		// algorithm: 密碼學演算法
        // 名詞解釋：
		// DES : Data Encryption Standard, 一種對稱式加密演算法。
		// 美國聯邦政府於1976年定為聯邦資料處理標準(FIPS)，它的
		// 金鑰則必須是7個位元組、加密區塊(Cipher Block)固定為8個位元組。
		// DES目前已被視為是一種不安全的演算法。
		// AES : Advanced Encryption Standard, 一種對稱式加密演算法。
		// (美國聯邦政府於2001年納入FIPS 140-2標準)，此種演算法
		// 的Cipher Block固定為16個位元組。金鑰則必須是16個位元組、
		// 24個位元組或32個位元組(即128個位元、192個位元或256個位元)。
		// ECB : Electronic CookBook, 一種資料的加密模式，這種加密模式採取
		// 每個區塊(如8個或16個位元組)獨立加密，即加密任ㄧ區塊時與其它區塊
		// 無關。
		// PKCS5Padding: 如果要加密的資料不是8個(如DES加密演算法)或
		// 16個(如AES加密演算法)位元組的整數倍，則必須在欲加密資料的
		// 尾端加入若干個位元組來湊成整數倍。PKCS5Padding是一種
		// 補足不足位元組的方法。

		// 取得Cipher物件
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		// SecretKeySpec類別會根據一個位元組陣列建構一個金鑰 SecretKey，此位元組陣列
		// 是由密碼來產生，其長度必須是16個位元組、24個位元組或32個位元組
		// 本方法使用AES對稱式加密演算法
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
		// 初始化，說明要加密或是要解密，並傳入金鑰
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
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
	 */
	public static String decryptStringECB(String key, String stringToDecrypt)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
		// 初始化，說明要加密或是要解密，並傳入金鑰
		cipher.init(Cipher.DECRYPT_MODE, secretKey);

		// 先將加密的字串由BASE64的字串反轉為byte[]
		byte[] b = DatatypeConverter.parseBase64Binary(stringToDecrypt);
		// 呼叫cipher.doFinal(b)開始對參數b進行解密
		String decryptedString = new String(cipher.doFinal(b));
		return decryptedString;

	}

	/**
	 * 本方法可對未加密的InputStream加密，加密後的資料寫入OutputStream，key為加密金鑰
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws IOException 
	 */
	public static void encryptStream(String key, InputStream is, OutputStream os) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException
	{
		// 準備能進行加密與解密運算Cipher類別的物件。
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		CipherInputStream cis = new CipherInputStream(is, cipher);
		doCopy(cis, os);

	}

	/**
	 * 本方法可對加密的InputStream解密，解密後的資料寫入OutputStream, key為當初加密時所用的金鑰
	 * @throws InvalidKeyException 
	 * @throws IOException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static void decryptStream(String key, InputStream is, OutputStream os) throws InvalidKeyException, IOException, NoSuchAlgorithmException, NoSuchPaddingException
			 {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		CipherOutputStream cos = new CipherOutputStream(os, cipher);
		doCopy(is, cos);
	}

	public static void doCopy(InputStream is, OutputStream os)
			throws IOException {
		byte[] bytes = new byte[8192];
		int numBytes;
		try {
			while ((numBytes = is.read(bytes)) != -1) {
				os.write(bytes, 0, numBytes);
			}
		} finally {
			if (os!=null){
				try {
					os.flush();	
				} catch(IOException e){
					e.printStackTrace();
				}
			}
			if (os!=null){
				try {
					os.close();	
				} catch(IOException e){
					e.printStackTrace();
				}
			}
			if (is!=null){
				try {
					is.close();	
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	

	/** 
	 *   本方法可對未加密的InputStream加密，加密後的資料寫入OutputStream
	 *   key為加密金鑰  
	 */
	private static boolean fileCompare(FileInputStream fisp, FileInputStream fisp2) throws IOException {
		System.out.println("開始比對...");
		long s, e;
	    s = System.currentTimeMillis();
		if ( fisp.available() != fisp2.available() ){
			return false;
		}
		byte [] b1 = new byte[81920];
		byte [] b2 = new byte[81920];
		int len ; 
		int total = 0 ;
		while ( (len=fisp.read(b1))!=-1 && (len=fisp2.read(b2))!=-1){
			total += len;
			if ( !Arrays.equals(b1, b2) ){
				e = System.currentTimeMillis();
				System.out.println("比對不符, " + "需時:" + (e-s));
				System.out.println();
				return false;
			}	
		}
		System.out.println("比對之位元組數=" + total);
		e = System.currentTimeMillis();
		System.out.println("完全相同, " + "需時:" + (e-s));
		return true;
	}
	public static String getStringMD5(String message) {
		final StringBuffer buffer = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(message.getBytes());
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