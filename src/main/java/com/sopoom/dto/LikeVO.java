package com.sopoom.dto;

public class LikeVO {
	
	private String p_id;
	private String userid;
	private String prdLikeVal;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getPrdLikeVal() {
		return prdLikeVal;
	}
	public void setPrdLikeVal(String prdLikeVal) {
		this.prdLikeVal = prdLikeVal;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

}