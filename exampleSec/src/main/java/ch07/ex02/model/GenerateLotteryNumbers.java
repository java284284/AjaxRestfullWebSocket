package ch07.ex02.model;

import java.io.Serializable;
import java.util.*;

public class GenerateLotteryNumbers implements Serializable {
	private static final long serialVersionUID = 1L;
	int maxNumber = 0;
	int amountOfBalls = 1;
	Integer [] numbers ={-1} ;
	String numsString = "";
	
	public GenerateLotteryNumbers (int maxNumber,int amountOfBalls){
		this.maxNumber = maxNumber;
		this.amountOfBalls = amountOfBalls;
	}
	
	public Integer[] getNumbers() {
		Set<Integer> set = new TreeSet<Integer>();
		while (set.size() < amountOfBalls) {
			int num = (int)(Math.random() * maxNumber) + 1;
			set.add(num);
		}
		Integer[] a = {}; 
		numbers = set.toArray(a);
        return numbers;
	}

	public GenerateLotteryNumbers (){
	}
	
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	public int getAmountOfBalls() {
		return amountOfBalls;
	}
	public void setAmountOfBalls(int amountOfBalls) {
		this.amountOfBalls = amountOfBalls;
	}
	public String getNumsString() {
	    numsString = "" ; 
	    if (numbers[0] == -1) {
	       getNumbers();
	    }
	    for ( int n = 0 ; n < numbers.length; n++) {
	    	numsString += numbers[n] + " ";
	    }
		return numsString;
	}
}
