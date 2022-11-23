package com.sopoom.service;

import java.util.ArrayList;
import java.util.List;

import com.sopoom.dto.CartVO;
import com.sopoom.dto.ProductVO;

public interface CartService {
	//Controller 와 소통하는 부분
	
	// 유저 카트 목록 불러오기
	public List<CartVO> selectCart(String userid) throws Exception; 
	
	//product table 에서 Cart table에 담긴 상품 종류 정보 가져오기
	public List<ProductVO> selectCartProductInfo(ArrayList<String> p_idList) throws Exception;

}
