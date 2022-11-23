package com.sopoom.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
}
