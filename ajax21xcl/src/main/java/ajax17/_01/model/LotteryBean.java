package ajax17._01.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LotteryBean {
    private int lowerBound;
    private int upperBound;
    private int ballNumber;
	public LotteryBean() {
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
    
	public Collection<Integer> getLuckyNumbers() {
	    Set<Integer> set = new TreeSet<Integer>();
	    while (set.size() < ballNumber ) {
	    	int num = (int)(Math.random()* (upperBound-lowerBound+1) + lowerBound);
	    	set.add(num);
	    }
		return set;
	}
	public Collection<Integer> getFourStars() {
	    List<Integer> list = new ArrayList<Integer>();
	    while (list.size() < ballNumber ) {
	    	int num = (int)(Math.random()* (upperBound-lowerBound+1) + lowerBound);
	    	list.add(num);
	    }
		return list;
	}
}
