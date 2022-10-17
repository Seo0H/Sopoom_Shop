package com.sopoom.dao;

import com.sopoom.dto.ProductVO;

public interface AdminProductDAO {

	//admin - 상품 등록
	public void productReg(ProductVO board) throws Exception;
	
	//admin - 중복 상품 이름 체크
	public int pidCheck(String p_id) throws Exception;
	
}
