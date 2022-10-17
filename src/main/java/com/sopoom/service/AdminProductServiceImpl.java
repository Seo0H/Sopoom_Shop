package com.sopoom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopoom.dao.AdminProductDAO;
import com.sopoom.dto.ProductVO;

@Service
public class AdminProductServiceImpl implements AdminProductService {

	@Autowired
	AdminProductDAO dao; 
	
	//admin - 상품 등록 
	@Override
	public void productReg(ProductVO board) throws Exception {
		dao.productReg(board);		
	}
	
	//admin - 상품 이름 중복 체크 
	@Override
	public int pidCheck(String p_id) throws Exception{
		return dao.pidCheck(p_id);
	}
}
