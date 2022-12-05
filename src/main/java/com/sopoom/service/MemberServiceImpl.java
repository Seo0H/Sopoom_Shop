package com.sopoom.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopoom.dao.MemberDAO;
import com.sopoom.dto.MemberVO;
import com.sopoom.dto.ProductVO;
import com.sopoom.dto.ShippingVO;

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
	public List<Map<String, String>> myOrder(String userid) {
		return dao.myOrder(userid);
	}

	// 마이페이지: 배송 수정
	@Override
	public void modifyOrder(ShippingVO shippingvo) {
		dao.modifyOrder(shippingvo);
	}
	
	//마이페이지: 배송 수정 : 재고 상태 변경
	//1. ship_id를 통해 orderedItem table에서 pID(상품번호), count(주문수량) 가져오기
	@Override
	public List<Map<String, Object>> selectOrderedItem(String shipID) {
		return dao.selectOrderedItem(shipID);
	}
	
	//2. product table에서 재고값 가져오기
	@Override
	public int selectP_unitsInStock(String pID) {
		return dao.selectP_unitsInStock(pID);
	}
	
	//3. product table 재고 변경
	@Override
	public void modifyStock(ProductVO productvo) {
		dao.modifyStock(productvo);
	}
}
