package com.sopoom.dao;
import java.util.List;

import com.sopoom.dto.CartVO;

public interface CartDAO {
	
	//카트에 추가
	public int insertCart(CartVO cart);
	
	//카트 업데이트
	public int updateCart(CartVO cart);
	
	//카트 삭제
	public int deleteCart(String p_id);
	
	//카트 초기화
	public int clearCart(String userid);
	
	//모든 카트 상품 선택
	public List<CartVO> selectAllCartList(String userid);
	
	
}
