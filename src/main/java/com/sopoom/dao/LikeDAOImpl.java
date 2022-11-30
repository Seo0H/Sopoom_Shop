package com.sopoom.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopoom.dto.LikeVO;
import com.sopoom.dto.ProductVO;

@Repository
public class LikeDAOImpl implements LikeDAO {

	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.sopoom.mappers.dibs";

	@Override
	public LikeVO getPrdLikeVal(String p_id) {
		return sql.selectOne(namespace + ".dibs", p_id);
	}

	@Override
	public void setPrdctLike(LikeVO LikeVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int prdctLikeCancel(LikeVO LikeVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
