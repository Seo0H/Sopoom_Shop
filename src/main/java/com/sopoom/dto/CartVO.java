package com.sopoom.dto;

public class CartVO {
	private String userid; //유저 아이디
	private String p_id; //제품 아이디
	private int quantity; //수량

	
	public CartVO(){ //생성자
		
	}
	
	public CartVO(String userid, String p_id,  int quantity) {
		super();
		this.userid = userid;
		this.p_id = p_id;
		this.quantity = quantity;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public int getquantity() {
		return quantity;
	}

	public void setquantity(int quantity) {
		this.quantity = quantity;
	}

	
	
}
