package com.sopoom.dao;

import java.util.List;
import com.sopoom.dto.MemberVO;

public interface MemberDAO {

	//사용자 전부 목록 가져오기
	public List<MemberVO> allMemberInfoView();
	
	//사용자 정보 가져오기
	public MemberVO userInfoView(String userId); 
}
