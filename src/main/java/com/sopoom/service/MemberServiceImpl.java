package com.sopoom.service;

import java.util.List;

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

}
