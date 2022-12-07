
package com.sopoom.service;
import java.util.List;
import com.sopoom.dto.ProductVO;

public interface ProductService {

	//게시물 목록보기
	public List<ProductVO> list() throws Exception;
	
	// 제품 상세 보기
	public ProductVO product(String p_id) throws Exception;

}
