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
	
	//카테고리 보기
	@Override
	public List<ProductVO> selCategory(String category) {
		return dao.selCategory(category);
	}
}
