package com.sopoom.dao;
import java.util.ArrayList;
import java.util.List;

import com.sopoom.dto.CartVO;
import com.sopoom.dto.ProductVO;

public interface CartDAO {
	
	//카트 상품 불러오기
	public List<CartVO> selectCart(String userid) throws Exception; 
	
	//product table 에서 Cart table에 담긴 상품 종류 정보 가져오기
	public List<ProductVO> selectCartProductInfo(ArrayList<String> p_idList) throws Exception;

	
//	//카트에 추가
//	public int insertCart(CartVO cart);
//	
//	//카트 업데이트
//	public int updateCart(CartVO cart);
//	
//	//카트 삭제
//	public int deleteCart(String p_id);
//	
//	//카트 초기화
//	public int clearCart(String userid);
//	
//	//모든 카트 상품 선택
//	public List<CartVO> selectAllCartList(String userid);
	
	
}
