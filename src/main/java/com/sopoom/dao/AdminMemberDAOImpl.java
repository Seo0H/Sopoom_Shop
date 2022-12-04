package com.sopoom.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopoom.dto.MemberVO;

@Repository
public class AdminMemberDAOImpl implements AdminMemberDAO{

	@Autowired
	SqlSession sql;
	
	private static String namespace = "com.sopoom.mappers.admin.member";

	public List<MemberVO> allMemberInfoView() {
		return sql.selectList(namespace + ".allMemberInfoView"); 
	}
	
	//사용자 개인 정보 보기
	public MemberVO memberInfoView(String userID) {
		return sql.selectOne(namespace + ".memberInfoView", userID);
	}
	
	//회원 탈퇴 처리
	public void deleteMember(String userID){
		sql.update(namespace + ".deleteMember", userID);
	}

	//회원 정보 수정
	public void modifyMember(MemberVO member){
		sql.update(namespace + ".modifyMember", member);
	}
	
	//전체 게시물 갯수 계산
		@Override
		public int totalCount(String searchType,String keyword) throws Exception{
			
			Map<String,String> data = new HashMap<>();
			data.put("searchType", searchType);
			data.put("keyword", keyword);
			return sql.selectOne(namespace + ".totalCount", data);
		}
}
