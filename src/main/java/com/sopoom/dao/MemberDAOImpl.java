package com.sopoom.dao;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopoom.dto.AddressVO;
import com.sopoom.dto.MemberVO;
import com.sopoom.dto.ProductVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	SqlSession sql;
	
	private static String namespace = "com.sopoom.mappers.admin.member";
	
	//아이디 확인
	@Override
	public int idCheck(String userid) {
		return sql.selectOne("com.sopoom.mappers.member.idCheck", userid);
	}

	//로그인 정보 확인
	@Override
	public MemberVO login(String userid) {
		return sql.selectOne(namespace + ".login", userid);
	}

	//로그인 시 마지막 로그인 날짜 등록
	@Override
	public void logindateUpdate(String userid) {
		sql.update(namespace + ".logindateUpdate", userid);
	}	

	//welcome 페이지 정보 가져 오기 
		public MemberVO welcomeView(String userid) {
			return sql.selectOne(namespace + ".welcomeView", userid);
		}

	//로그 아웃 날짜 등록
	@Override
	public void logoutUpdate(String userid) {
		sql.insert(namespace + ".logoutUpdate",userid);
		
	}

	//사용자 정보 등록
	@Override
	public void memberInfoRegistry(MemberVO member) {
		sql.insert(namespace + ".memberInfoRegistry", member);
	}

	//사용자 정보 보기
	@Override
	public MemberVO memberInfoView(String userid) {
		return sql.selectOne(namespace + ".memberInfoView", userid);
	}

	//우편번호 최대 행수 계산
	@Override
	public int addrTotalCount(String addrSearch) {
		return sql.selectOne(namespace+".addrTotalCount",addrSearch);
	}

	//우편번호 검색 15
	@Override
   public List<AddressVO> addrSearch(int startPoint, int endPoint, String addrSearch) {

      Map<String,Object> data = new HashMap<>();
      data.put("startPoint", startPoint);
      data.put("endPoint",endPoint);
      data.put("addrSearch", addrSearch);
      
      return sql.selectList(namespace + ".addrSearch", data);
   }

	public List<MemberVO> allMemberInfoView() {
		return sql.selectList(namespace + ".allMemberInfoView"); 
	}

}
