package com.sopoom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopoom.dao.AdminMemberDAO;
import com.sopoom.dto.MemberVO;

@Service
public class AdminMemberServiceImpl implements AdminMemberService {

	@Autowired
	AdminMemberDAO dao; 
	
	@Override
	public List<MemberVO> allMemberInfoView(int postNum, int startPoint, int endPoint, String searchType, String keyword) throws Exception {
		return dao.allMemberInfoView(postNum, startPoint,endPoint,searchType,keyword);
	}
	
	//사용자 개인 정보 보기
	@Override
	public MemberVO memberInfoView(String userID){
		return dao.memberInfoView(userID);
	}
	
	//회원 탈퇴 처리
	public void deleteMember(String userID){
		dao.deleteMember(userID);
	}
	
	//회원 정보 수정
	public void modifyMemberInfo(MemberVO member){
		dao.modifyMember(member);
	}

	//전체 게시물 갯수 계산
		@Override
		public int totalCount(String searchType,String keyword) throws Exception{
			return dao.totalCount(searchType, keyword);
		}
}
