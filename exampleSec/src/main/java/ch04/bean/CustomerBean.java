package ch04.bean;

import java.io.*;
import java.util.*;

public class CustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	int pId;
	String pName;
	int amount;
	Date expire;	
	public CustomerBean() {
	}
	// 此方法定義可讀性質 productId
	public int getProductId() {
		return pId;
	}
	// 此方法定義可寫性質 productId
	public void setProductId(int productId) {
		this.pId = productId;
	}
	// 此方法定義可讀性質 productName
	public String getProductName() {  // 
		return pName;
	}
	// 此方法定義可寫性質 productName
	public void setProductName(String productName) {
		this.pName = productName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getExpire() {
		return expire;
	}
	public void setExpire(Date expire) {
		this.expire = expire;
	}
}