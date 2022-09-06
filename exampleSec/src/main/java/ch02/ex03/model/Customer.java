package ch02.ex03.model;

public class Customer implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	String email;
	String tel;
	String[] fruits;
	public Customer() {
	}
	public Customer(String name, String email, String tel, String[] fruits) {
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.fruits = fruits;
	}

	public String getEmail() {
		return  email;
	}

	public void setAddress(String email) {
		this.email = email;
	}

	public String[] getFruits() {
		return fruits;
	}

	public void setFruits(String[] fruits) {
		this.fruits = fruits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
