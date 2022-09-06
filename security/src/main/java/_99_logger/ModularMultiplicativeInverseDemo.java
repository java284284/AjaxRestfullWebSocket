package _99_logger;

import java.math.BigInteger;
// Java語言計算整數a的模反元素的範例:
// 模反元素:整數a對同餘n的模反元素b
// a * b = 1 (mod n)

public class ModularMultiplicativeInverseDemo {
	public static void main(String[] args) {
		BigInteger a = new BigInteger("17");
		BigInteger m = new BigInteger("3120");
		System.out.println(a.modInverse(m));
	}
}
