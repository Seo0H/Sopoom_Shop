package com.sopoom.dao;

import java.util.List;

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
	public List<ShippingVO> shippingList() throws Exception {
		return sql.selectList(namespace + ".shippingList"); 
	}
}
