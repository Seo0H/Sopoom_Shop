package com.sopoom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopoom.dao.CartDAO;
import com.sopoom.dto.CartVO;
import com.sopoom.dto.ProductVO;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartDAO dao;

	// 유저 카트 목록 불러오기
	@Override
	public List<CartVO> selectCart(String userid) throws Exception {
		return dao.selectCart(userid);
	}
	
	//product table 에서 Cart table에 담긴 상품 종류 정보 가져오기
	@Override
	public List<ProductVO> selectCartProductInfo(ArrayList<String> p_idList) throws Exception {
		return dao.selectCartProductInfo(p_idList);
	}

}
