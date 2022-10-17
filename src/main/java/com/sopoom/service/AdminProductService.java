package com.sopoom.service;

import com.sopoom.dto.ProductVO;

public interface AdminProductService {

	//admin - 상품 등록
	public void productReg(ProductVO board) throws Exception;
	
	//admin - 중복 상품 아이디 체크
	public int pidCheck(String p_id) throws Exception;
}
