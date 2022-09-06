package ch07.ex07.model;

import java.io.Serializable;

public class CoffeeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int coffeeCode;
	private String coffeeName;
	private double price;
	private double discount;

	public CoffeeBean(int coffeeCode, String coffeeName, double price,
			double discount) {
		this.coffeeCode = coffeeCode;
		this.price = price;
		this.coffeeName = coffeeName;
		this.discount = discount;
	}

	public CoffeeBean() {
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public double getPrice() {
		return price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getCoffeeCode() {
		return coffeeCode;
	}
}
