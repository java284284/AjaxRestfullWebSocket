package _00_init.misc;

public class XORDemo0 {

	public static void main(String[] args) {
		int i1 = 24 ;       // 000...00011000
		int i2 = 18 ;       // 000...00010010
		                    // 000...00001010
		
		// 互斥或 :	相同為假，位元0與位元0，以及位元1與位元1
		//       	相異為真，位元1與位元0，以及位元0與位元1
		
		int i3 = i1 ^ i2;
		System.out.println("i1=" + i1);
		System.out.println("i2=" + i2);
		System.out.println("i3=" + i3);
		System.out.println("----------------------");
		int ix ;
		ix = i3 ^ i2;
		System.out.println("i3與i2互斥，ix=" + ix);
		ix = i3 ^ i1;
		System.out.println("i3與i1互斥，ix=" + ix);
		
	}
}
