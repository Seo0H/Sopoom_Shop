package com.sopoom.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopoom.dto.CartVO;
import com.sopoom.dto.ProductVO;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	SqlSession sql;
	
	private static String namespace = "com.sopoom.mappers.ShopC";
	
	// mapper.xml에서 유저 카트 목록 불러오기
	@Override
	public List<CartVO> selectCart(String userid){
		return sql.selectList(namespace +".selectCart", userid);
	}
	
	//product table 에서 Cart table에 담긴 상품 종류 정보 가져오기
	@Override
	public List<ProductVO> selectCartProductInfo(ArrayList<String> p_idList) throws Exception {
		HashMap<String, Object> data = new HashMap<>();
		data.put("p_idList", p_idList);
		return sql.selectList(namespace+ ".selectCartProductInfo" , data);
	}

	//카트 선택 상품 삭제
	@Override
	public void selectDel(Map<String,Object> data) throws Exception {
		sql.delete(namespace+".selectDel", data);
	}

	//유저 카트 비우기
	@Override
	public void allDel(String userid) throws Exception {
		sql.delete(namespace+".allDel", userid);
	}
	
	//카트에 상품 추가
	@Override
	public void addCart(CartVO cart) {
		sql.insert(namespace+".addCart", cart);
		
	}
	
}
