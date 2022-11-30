package com.sopoom.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopoom.dao.LoginDAO;
import com.sopoom.dto.MemberVO;


@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDAO dao; 
	
	//로그인 정보 확인
	@Override
	public MemberVO login(String userid) {
		return dao.login(userid);
	}
	
	//아이디 확인
	@Override
	public int idCheck(String userid) {
		return dao.idCheck(userid);
	}
	
	//사용자 등록
	@Override
	public void memberInfoRegistry(MemberVO member) {
		dao.memberInfoRegistry(member);
	}
	
	//사용자 비밀번호 찾기 - 정보와 일치하는 사용자 찾기
	@Override
	public int findPWfindUser(MemberVO member) {
		return dao.findPWfindUser(member);
	}

	@Override
	public void findPWtempPW(MemberVO member) {
		// TODO Auto-generated method stub		
		dao.findPWtempPW(member);
	}
	
	//사용자 아이디 찾기
	@Override
	public String searchID(MemberVO member) {
		return dao.searchID(member);
	}
	
}
