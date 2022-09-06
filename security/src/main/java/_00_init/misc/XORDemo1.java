package _00_init.misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class XORDemo1 {

	public static void main(String[] args) {
		long src = (long)(Math.random()* 100000000000L) + 1;
		Long[] la = {11209928882000L, 22598392329238L, 
				     55372837283723L, 33028252938293L, 44930100232293L};
		System.out.println("最初隨機產生的Long型態的整數(src)=" + src);		
        for(int n=0; n < la.length; n++){
        	src ^= la[n];   //    ^=: 先做XOR運算，接著做加運算  
        }
        long xor = src;  // 
        System.out.println("------------------------------");
        System.out.println("src多次互斥或之後結果(xor)=" + xor);
        System.out.println("------------------------------");
        
        for(int n=0; n < la.length; n++){
        	xor ^= la[n];       
        }
        System.out.println("xor多次互斥或之後結果(正序,  xor)=" + xor);
        System.out.println("------------------------------");
        xor = src;  // 
        for(int n=la.length-1; n >= 0 ; n--){
        	xor ^= la[n];         
        }		
        System.out.println("xor多次互斥或之後結果(倒序,  xor)=" + xor);	
        System.out.println("------------------------------");
        List<Long>  list = new LinkedList<>(Arrays.asList(la));
        xor = src;  // 
        while (list.size() > 0){
        	int rand = (int)(Math.random() * list.size()) + 0;
        	//System.out.println(list.get(rand));
        	long num = list.remove(rand);
        	//System.out.println(num);
        	xor ^= num ;
        }  
        System.out.println("xor多次互斥或之後結果(隨機,  xor)=" + xor);
	}

}
