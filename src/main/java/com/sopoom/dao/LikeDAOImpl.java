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
	public int dibs(LikeVO likeVO) {
		return sql.selectOne(namespace+".dibs", likeVO);
	}
	
	@Override
	public List<ProductVO> getPrdLikeVal(String userid) {
		return sql.selectList(namespace + ".getPrdLikeVal", userid);
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
