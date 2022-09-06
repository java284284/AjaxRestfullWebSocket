package ch03.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import ch03.model.LotteryBean;

@Service
public class LotteryService  implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private int lowerBound;
    private int upperBound;
    private int ballNumber;
	public LotteryService() {
	}
	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}
	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}
	public void setBallNumber(int ballNumber) {
		this.ballNumber = ballNumber;
	}
    
	public LotteryBean getLuckyNumbers() {  	// luckyNumbers
	    
		Set<Integer> set = new TreeSet<Integer>();
	    while (set.size() < ballNumber ) {
	    	int num = (int)(Math.random()* (upperBound-lowerBound+1) + lowerBound);
	    	set.add(num);
	    }
	    LotteryBean bean = new LotteryBean(set);
		return bean;
	}
	
	public LotteryBean getFourStars() {  		// fourStars
	    List<Integer> set = new ArrayList<Integer>();
	    while (set.size() < ballNumber ) {
	    	int num = (int)(Math.random()* (upperBound-lowerBound+1) + lowerBound);
	    	set.add(num);
	    }
	    LotteryBean bean = new LotteryBean(set);
		return bean;
	}
}
