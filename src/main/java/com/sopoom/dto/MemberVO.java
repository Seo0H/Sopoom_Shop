package com.sopoom.dto;

import java.time.LocalDateTime;

//Admin - 회원 목록 보기 구현
public class MemberVO {

	private String userID;
	private String password;
	private String username;
	private String postcode;
	private String address;
	private String detailAddress;
	private String extraAddress;
	private String telno;
	private String email;
	
	public MemberVO() {
		super();
	}

	public MemberVO(String userID, String password, String username, String postcode, String address,
			String detailAddress, String extraAddress, String telno, String email) {
		this.userID = userID;
		this.password = password;
		this.username = username;
		this.postcode = postcode;
		this.address = address;
		this.detailAddress = detailAddress;
		this.extraAddress = extraAddress;
		this.telno = telno;
		this.email = email;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getExtraAddress() {
		return extraAddress;
	}

	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}