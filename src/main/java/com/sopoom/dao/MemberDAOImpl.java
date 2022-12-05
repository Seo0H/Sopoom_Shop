package com.sopoom.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopoom.dto.MemberVO;
import com.sopoom.dto.ProductVO;
import com.sopoom.dto.ShippingVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	SqlSession sql;
	
	private static String namespace = "com.sopoom.mappers.admin.member";
	private static String mypageNamespace = "com.sopoom.mappers.mypage.member";

	public List<MemberVO> allMemberInfoView() {
		return sql.selectList(namespace + ".allMemberInfoView"); 
	}
	
	//사용자 정보 가져오기
	@Override
	public MemberVO userInfoView(String userId) {
		return sql.selectOne(mypageNamespace + ".userInfoView", userId);
	}
	
	//아이디로 비밀번호 가져오기
	@Override
	public String pwCheck(String userid) {
		return sql.selectOne(mypageNamespace + ".pwCheck", userid);
	}
	
	//마이페이지: 기본 정보 수정
	@Override
	public void changeInfo(Map<String, String> data) {
		sql.update(mypageNamespace + ".changeInfo", data);
	}
	
	
	//마이페이지: 비밀번호 변경
	@Override
	public void pwModify(Map<String, String> data) {
		sql.update(mypageNamespace + ".pwModify", data);
	}
	
	//마이페이지: 배송 조회
	@Override
	public List<Map<String, String>> myOrder(String userid) {
		List<Map<String, String>> data = sql.selectList(mypageNamespace+".myOrder", userid);
		return data;
	}
	
	//마이페이지: 배송 수정
	//상품의 재고 수정
	//결제완료 -> 재고 결제한만큼 감소
	//주문취소 -> 재고 결제수량만큼 증가

	//마이페이지: 배송 수정 : 재고 상태 변경
	//1. ship_id를 통해 orderedItem table에서 pID(상품번호), count(주문수량) 가져오기
	@Override
	public List<Map<String, Object>> selectOrderedItem(String shipID) {
		List<Map<String, Object>> data = sql.selectList(mypageNamespace + ".selectOrderedItem", shipID);
		return data;
	}
	
	//2. product table에서 재고값 가져오기
	@Override
	public int selectP_unitsInStock(String p_id) {
		return sql.selectOne(mypageNamespace + ".selectP_unitsInStock", p_id);
	}
	
	//3. product table 재고 변경
	@Override
	public void modifyStock(ProductVO productvo) {
		sql.update(mypageNamespace+".modifyStock", productvo);
	}
	
	//4.  배송 상태 변경
	@Override
	public void modifyOrder(ShippingVO shippingvo) {
		sql.delete(mypageNamespace+".modifyOrder",shippingvo);
	}

}
