package com.sopoom.service;

import java.util.List;

import com.sopoom.dto.MemberVO;


public interface MemberService {

	//사용자 전부 목록 가져오기
	public List<MemberVO> allMemberInfoView();
	
	//사용자 정보 가져오기
	public MemberVO userInfoView(String userid); 
	
}
