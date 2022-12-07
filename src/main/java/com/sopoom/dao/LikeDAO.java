package com.sopoom.dao;

import java.util.List;

import com.sopoom.dto.LikeVO;
import com.sopoom.dto.ProductVO;

public interface LikeDAO {
	
	// 찜 여부 알아보기
	public int dibs(LikeVO likeVO);

	// 해당 상품 찜 여부 확인용 데이터 가져오기
	public List<ProductVO> getPrdLikeVal(String userid);

	// 상품 상세 페이지 찜하기
	public void setPrdctLike(LikeVO LikeVO);

	// 상품 상세페이지 찜취소 기능
	public void prdctLikeCancel(LikeVO LikeVO);

	
}
