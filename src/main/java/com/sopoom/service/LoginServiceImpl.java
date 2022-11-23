package com.sopoom.service;

import java.util.List;

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

	//사용자 아이디 찾기
	@Override
	public String searchPW(MemberVO member) {
		return dao.searchPW(member);
	}
}
