package com.sopoom.dao;

import java.util.List;
import com.sopoom.dto.ProductVO;

public interface ProductDAO {

	//게시물 목록보기
	public List<ProductVO> list() throws Exception;

	//카테고리 보기
	public List<ProductVO> selCategory(String category);
	
}
