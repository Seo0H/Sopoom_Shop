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
	
	// 해당 상품 찜 여부 확인용 데이터 가져오기 (void를 productVO나 map으로 둬야함?)
	@Override
	public ProductVO getPrdLikeVal(String p_id) {
//	    log.info("getPrdLikeVal...");
	    return dao.getPrdLikeVal(p_id);
	}

	// 상품 상세 페이지 찜하기
	public void setPrdctLike(ProductVO ProductVO) {
//	    log.info("setPrdctLike...");
	    dao.setPrdctLike(ProductVO);
	}

	// 상품 상세페이지 찜취소 기능
	public int prdctLikeCancel(ProductVO ProductVO) {
//	    log.info("prdctLikeCancel...");
	    return dao.prdctLikeCancel(ProductVO);
	}
}
