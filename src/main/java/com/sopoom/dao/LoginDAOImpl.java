package com.sopoom.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopoom.dto.MemberVO;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	@Autowired
	SqlSession sql;
	
	private static String namespace = "com.sopoom.mappers.login";
	
	//로그인 정보 확인
	@Override
	public MemberVO login(String userid) {
		return sql.selectOne(namespace+".login", userid);
	}
	
	//아이디 확인
	@Override
	public int idCheck(String userid) {
		return sql.selectOne(namespace+".idCheck", userid);
	}

	//사용자 정보 등록
	@Override
	public void memberInfoRegistry(MemberVO member) {
		sql.insert(namespace + ".memberInfoRegistry", member);
	}


	//사용자 비밀번호 찾기
	@Override
	public int findPWfindUser(MemberVO member) {
		return sql.selectOne(namespace + ".findPWfindUser", member);
	}

	@Override
	public void findPWtempPW(MemberVO member) {
		sql.update(namespace+".findPWtempPW", member);
	}


}
