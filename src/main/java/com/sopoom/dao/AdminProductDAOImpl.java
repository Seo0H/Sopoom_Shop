package com.sopoom.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopoom.dto.ProductVO;

@Repository
public class AdminProductDAOImpl implements AdminProductDAO {

	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.sopoom.mappers.admin.Product";

	//admin - 상품 등록
	@Override
	public void productReg(ProductVO board) throws Exception {
		sql.insert(namespace + ".productReg", board);
	}
	
	//admin - 중복 상품 이름 체크
	public int pidCheck(String p_id) throws Exception {	
		return sql.selectOne(namespace + ".pidCheck", p_id);
	}
}
