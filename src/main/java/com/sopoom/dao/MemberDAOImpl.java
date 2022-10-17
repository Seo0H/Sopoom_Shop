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

	public List<MemberVO> allMemberInfoView() {
		return sql.selectList(namespace + ".allMemberInfoView"); 
	}

}
