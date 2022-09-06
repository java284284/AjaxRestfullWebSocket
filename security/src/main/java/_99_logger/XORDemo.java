package _99_logger;

public class XORDemo {
	public static void main(String[] args) {
          long[] xa = {1000, 2000, 30000, 12345678900L, 258775666555L, 96655444222L, 123456258L};
          long key = 1001000;
          System.out.println("1. key=" + key);
          for(int n=0 ; n < xa.length; n++){
        	  key ^= xa[n];
          }          
          System.out.println("2. key=" + key);
          for(int n=xa.length-1 ; n >= 0; n--){
        	  key ^= xa[n];
          }
          System.out.println("3. key=" + key);

	}

}
