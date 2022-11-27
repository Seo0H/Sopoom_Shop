package com.sopoom.dto;

public class OrderVO {
	String orderID;
	String userID;
	int totalPrice;
	String orderDate;
	
	public OrderVO(){}
	
	public OrderVO(String orderID, String userID, int totalPrice, String orderDate) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
}
