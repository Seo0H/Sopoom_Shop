package com.sopoom.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopoom.dto.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	SqlSession sql;
	
	private static String namespace = "com.sopoom.mappers.admin.member";
	private static String mypageNamespace = "com.sopoom.mappers.mypage.member";

	public List<MemberVO> allMemberInfoView() {
		return sql.selectList(namespace + ".allMemberInfoView"); 
	}
	
	//사용자 정보 가져오기
	@Override
	public MemberVO userInfoView(String userId) {
		return sql.selectOne(mypageNamespace + ".userInfoView", userId);
	}
	
	//아이디로 비밀번호 가져오기
	@Override
	public String pwCheck(String userid) {
		return sql.selectOne(mypageNamespace + ".pwCheck", userid);
	}
	
	//마이페이지: 기본 정보 수정
	@Override
	public void changeInfo(Map<String, String> data) {
		sql.update(mypageNamespace + ".changeInfo", data);
	}
	
	
	//마이페이지: 비밀번호 변경
	@Override
	public void pwModify(Map<String, String> data) {
		sql.update(mypageNamespace + ".pwModify", data);
	}
	
	//마이페이지: 배송 조회
	@Override
	public Map<String, Object> myOrder(String userid) {
		return sql.selectMap(mypageNamespace+".myOrder", userid);
	}

}
