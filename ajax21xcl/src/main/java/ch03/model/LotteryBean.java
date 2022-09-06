package ch03.model;

import java.io.Serializable;
import java.util.Collection;

public class LotteryBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Collection<Integer> numbers ;
    
	public LotteryBean() {
	}
	
	public LotteryBean(Collection<Integer> numbers) {
		this.numbers = numbers;
	}

	public Collection<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(Collection<Integer> numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
	
}
