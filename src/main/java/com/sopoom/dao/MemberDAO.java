package com.sopoom.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sopoom.dto.AddressVO;
import com.sopoom.dto.MemberVO;

public interface MemberDAO {

	//사용자 전부 목록 가져오기
	public List<MemberVO> allMemberInfoView();
	
	//사용자 개인 정보 보기
	public MemberVO memberInfoView(String userID);
	
	//회원 탈퇴 처리
	public void deleteMember(String userID);
}
