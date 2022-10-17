package com.sopoom.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopoom.dto.InventoryVO;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.sopoom.mappers.admin.inventory";
	
	//게시물 목록 보기
	@Override
	public List<InventoryVO> inventoryList() throws Exception {
		return sql.selectList(namespace + ".inventoryList"); 
	}
}
