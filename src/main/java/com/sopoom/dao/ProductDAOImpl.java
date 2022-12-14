package com.sopoom.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.sopoom.dto.LikeVO;
import com.sopoom.dto.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.sopoom.mappers.product";
	
	//게시물 목록 보기
	@Override
	public List<ProductVO> list() throws Exception {
		return sql.selectList(namespace + ".list"); 
	}
	
	//카테고리 보기
	@Override
	public List<ProductVO> selCategory(String category) {
		System.out.println("category:"+category);
		return sql.selectList(namespace + ".selCategory", category);
	}

	// 제품 상세 보기
	@Override
	public ProductVO product(String p_id) throws Exception {
		return sql.selectOne(namespace + ".product", p_id);
	}

	@Override
	public ProductVO getPrdLikeVal(String p_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPrdctLike(ProductVO productVO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int prdctLikeCancel(ProductVO productVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
