package com.sopoom.dao;

import java.util.List;
import java.util.Map;

import com.sopoom.dto.ProductVO;
import com.sopoom.dto.FileVO;

public interface ProductDAO {

	//게시물 목록보기
	public List<ProductVO> list() throws Exception;
	
	// 제품 상세 보기
	public ProductVO product(String p_id) throws Exception;
	
}
