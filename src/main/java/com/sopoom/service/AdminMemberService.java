package com.sopoom.service;

import java.util.List;

import com.sopoom.dto.MemberVO;


public interface AdminMemberService {

	//사용자 전부 목록 가져오기
	public List<MemberVO> allMemberInfoView();
	
	//사용자 개인 정보 보기
	public MemberVO memberInfoView(String userID);
	
	//회원 탈퇴 처리
	public void deleteMember(String userID);
	
	//사용자 정보 수정
	public void modifyMemberInfo(MemberVO member);

	//전체 게시물 갯수 계산
	public int totalCount(String searchType,String keyword) throws Exception;

}
