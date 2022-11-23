package com.sopoom.dao;

import java.util.List;
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

}
