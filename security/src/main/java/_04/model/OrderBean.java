package _04.model;

public class OrderBean {
	int key;
	String orderId;
	double amount;

	public OrderBean(int key, String orderId, double amount) {
		this.key = key;
		this.orderId = orderId;
		this.amount = amount;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
