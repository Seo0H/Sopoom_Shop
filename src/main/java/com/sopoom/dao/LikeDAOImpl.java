package com.sopoom.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopoom.dto.LikeVO;

@Repository
public class LikeDAOImpl implements LikeDAO {

	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.sopoom.mappers.dibs";

	@Override
	public int dibs(LikeVO likeVO) {
		return sql.selectOne(namespace+".dibs", likeVO);
	}
	
	@Override
	public LikeVO getPrdLikeVal(String p_id) {
		return sql.selectOne(namespace + ".getPrdLikeVal", p_id);
	}

	@Override
	public void setPrdctLike(LikeVO LikeVO) {
		sql.insert(namespace+ ".setPrdctLike", LikeVO);
		
	}

	@Override
	public void prdctLikeCancel(LikeVO LikeVO) {
		 sql.delete(namespace+".prdctLikeCancel", LikeVO);
	}

}
