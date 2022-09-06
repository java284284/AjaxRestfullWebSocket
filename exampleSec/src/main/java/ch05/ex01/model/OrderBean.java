package ch05.ex01.model;

import java.io.Serializable;
import java.sql.Date;

public class OrderBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  int     orderNo;
    private  Date    orderDate;
    private  String  customerID;
    private  double  amount;
	public OrderBean(int orderNo, Date orderDate, String customerID,
			double amount) {
		super();
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.customerID = customerID;
		this.amount = amount;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
    
}
