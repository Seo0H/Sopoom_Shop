package com.sopoom.dao;

import java.util.List;

import com.sopoom.dto.ProductVO;

public interface ProductDAO {

	//게시물 목록보기
	public List<ProductVO> list() throws Exception;
	
	// 제품 상세 보기
	public ProductVO product(String p_id) throws Exception;

	// 해당 상품 찜 여부 확인용 데이터 가져오기 (void를 productVO나 map으로 둬야함?
	public ProductVO getPrdLikeVal(String p_id) throws Exception;

	// 상품 상세 페이지 찜하기
	public void setPrdctLike(ProductVO productVO) throws Exception;

	// 상품 상세페이지 찜취소 기능
	public int prdctLikeCancel(ProductVO productVO) throws Exception;
	
}
