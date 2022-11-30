package com.sopoom.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopoom.dto.ShippingVO;

@Repository
public class AdminShippingDAOImpl implements AdminShippingDAO {

	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.sopoom.mappers.admin.shipping";

	//배송 목록보기
	@Override
	public List<ShippingVO> shippingList(int startPoint, int endPoint, String searchType,String keyword) throws Exception {
		return sql.selectList(namespace + ".shippingList"); 
	}

	//전체 게시물 갯수 계산
	@Override
	public int totalCount(String searchType,String keyword) throws Exception{
		
		Map<String,String> data = new HashMap<>();
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		return sql.selectOne(namespace + ".totalCount", data);
	}

	//수정
	@Override
	public void modifyShippingStatus(ShippingVO shipping) throws Exception {
		sql.update(namespace + ".modifyShippingStatus", shipping);		
	}

	@Override
	public ShippingVO shippingInfo(String shipID) throws Exception {
		return sql.selectOne(namespace + ".shippingInfo", shipID);
	}
}
