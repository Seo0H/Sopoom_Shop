package com.sopoom.service;

import java.util.Map;

import com.sopoom.dto.MemberVO;

public interface LoginService {
	
		//로그인 정보 확인
		public MemberVO login(String userid); 

		//아이디 확인
		public int idCheck(String userid); 

		//사용자 정보 등록
		public void memberInfoRegistry(MemberVO member);
		
		//사용자 비밀번호 찾기 - 정보와 일치하는 사용자 찾기
		public int findPWfindUser(MemberVO member);
		
		//사용자 비밀번호 찾기 - 임시 비밀번호 발급
		public void findPWtempPW(MemberVO member);
		
}
