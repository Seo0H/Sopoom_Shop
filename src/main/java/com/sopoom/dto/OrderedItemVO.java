package com.sopoom.dto;

public class OrderedItemVO {
	
	String orderID;
	String pID;
	int count;
	
	public OrderedItemVO() {}
	
	public OrderedItemVO(String orderID, String pID, int count) {
		super();
		this.orderID = orderID;
		this.pID = pID;
		this.count = count;
	}
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getpID() {
		return pID;
	}
	public void setpID(String pID) {
		this.pID = pID;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
