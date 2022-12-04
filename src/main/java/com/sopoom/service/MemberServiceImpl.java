package com.sopoom.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopoom.dao.MemberDAO;
import com.sopoom.dto.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO dao; 
	
	@Override
	public List<MemberVO> allMemberInfoView() {
		return dao.allMemberInfoView();
	}
	
	//사용자 정보 가져오기
	@Override
	public MemberVO userInfoView(String userId) {
		return dao.userInfoView(userId);
	}
	
	//사용자 비밀번호 확인
	@Override
	public String pwCheck(String userid) {
		return dao.pwCheck(userid);
	}
	
	//마이페이지: 기본 정보 수정
	@Override
	public void changeInfo(Map<String, String> data) {
		dao.changeInfo(data);
	}
	
	// 마이페이지: 비번 변경
	@Override
	public void pwModify(Map<String, String> data) {
		dao.pwModify(data);
	}
	
	//마이페이지: 배송 조회
	@Override
	public Map<String, Object> myOrder(String userid) {
		return dao.myOrder(userid);
	}
}
