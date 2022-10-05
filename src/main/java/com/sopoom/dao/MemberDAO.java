package com.sopoom.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.sopoom.dto.AddressVO;
import com.sopoom.dto.MemberVO;

public interface MemberDAO {

	//아이디 확인
	public int idCheck(String userid); 

	//로그인 정보 확인
	public MemberVO login(String userid); 

	//마지막 로그인 시간 등록
	public void logindateUpdate(String userid);
	
	//welcome 페이지 정보 가져 오기 
	public MemberVO welcomeView(String userid);

	//로그아웃 날짜 업데이트
	public void logoutUpdate(String userid);

	//사용자 정보 등록
	public void memberInfoRegistry(MemberVO member);

	//사용자 정보 보기
	public MemberVO memberInfoView(String userid);

	//주소 전체 갯수 계산
	public int addrTotalCount(String addrSearch);

	//주소 검색
	public List<AddressVO> addrSearch(int startPoint, int endPoint, String addrSearch);
	
}
