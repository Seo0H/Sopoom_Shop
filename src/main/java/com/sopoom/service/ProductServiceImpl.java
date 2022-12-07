package com.sopoom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopoom.dao.ProductDAO;
import com.sopoom.dto.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO dao; 
	
	//게시물 목록 보기
	@Override
	public List<ProductVO> list() throws Exception {
		
		return dao.list();
	}
	
	//제품 상세 보기
	@Override
	public ProductVO product(String p_id) throws Exception {
		
		return dao.product(p_id);
	}
}
