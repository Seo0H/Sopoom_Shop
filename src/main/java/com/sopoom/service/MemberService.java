package com.sopoom.service;

import java.util.List;
import java.util.Map;

import com.sopoom.dto.MemberVO;
import com.sopoom.dto.ProductVO;
import com.sopoom.dto.ShippingVO;


public interface MemberService {

	//사용자 전부 목록 가져오기
	public List<MemberVO> allMemberInfoView();
	
	//사용자 정보 가져오기
	public MemberVO userInfoView(String userid);
	
	//아이디로 비밀번호 가져오기
	public String pwCheck(String userid);
	
	//마이페이지: 기본 정보 수정
	public void changeInfo(Map<String, String> data);
	
	// 마이페이지: 비번 변경
	public void pwModify(Map<String, String> data);
	
	//마이페이지: 배송 조회
	public List<Map<String, String>> myOrder(String userid);
	
	// 마이페이지: 배송 수정
	public void modifyOrder(ShippingVO shippingvo);
	
	//마이페이지: 배송 수정 : 재고 상태 변경
	//1. ship_id를 통해 orderedItem table에서 pID(상품번호), count(주문수량) 가져오기
	public List<Map<String, Object>> selectOrderedItem(String shipID);
	
	//2. product table에서 재고값 가져오기
	public int selectP_unitsInStock(String pID);
	
	//3. product table 재고 변경
	public void modifyStock(ProductVO productvo);
	
}
