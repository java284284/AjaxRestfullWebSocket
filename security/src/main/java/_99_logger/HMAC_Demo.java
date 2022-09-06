package _99_logger;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMAC_Demo {
	//private static final String ALGORITHM = "HmacSHA1";
	private static final String ALGORITHM = "HmacMD5";
	public static void main(String[] args) throws Exception {
		String hmac = computeHmac(ALGORITHM, "data", "key");
		System.out.println(hmac);
	}

	public static String computeHmac(String algorithm, String key, String data)
			throws SignatureException, NoSuchAlgorithmException,
			InvalidKeyException {
		SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), algorithm);
		Mac mac = Mac.getInstance(algorithm);
		mac.init(signingKey);
		byte[] b = mac.doFinal(data.getBytes());
		return toHexString(b);
	}

	private static String toHexString(byte[] ba) {
		// 方法一: 
		String result = null;
        Formatter formatter = new Formatter();
		for (byte b : ba) {
			formatter.format("%02x", b);
		}
		result = formatter.toString();
		System.out.println("方法一: formatter.toString():" +  result);
		formatter.close();
		// 方法二:		
		StringBuffer sb = new StringBuffer(); 
		for (byte b : ba) {
			String s = Integer.toHexString(Byte.toUnsignedInt(b));
			sb.append(s.length()< 2 ? "0" + s : s);
		}
		System.out.println("方法二: StringBuffer        :" + sb.toString());
		return result;
	}
}
