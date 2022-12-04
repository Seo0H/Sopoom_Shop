package com.sopoom.service;

import java.util.List;
import java.util.Map;

import com.sopoom.dto.MemberVO;


public interface MemberService {

	//사용자 전부 목록 가져오기
	public List<MemberVO> allMemberInfoView();
	
	//사용자 정보 가져오기
	public MemberVO userInfoView(String userid);
	
	//아이디로 비밀번호 가져오기
	public String pwCheck(String userid);
	
	//마이페이지: 기본 정보 수정
	public void changeInfo(Map<String, String> data);
	
	// 마이페이지: 비번 변경
	public void pwModify(Map<String, String> data);
	
	//마이페이지: 배송 조회
	public Map<String, Object> myOrder(String userid);
	
	
}
