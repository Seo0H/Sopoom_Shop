package com.sopoom.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopoom.dto.InventoryVO;

@Repository
public class AdminInventoryDAOImpl implements AdminInventoryDAO {

	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.sopoom.mappers.admin.inventory";
	
	//게시물 목록 보기
	@Override
	public List<InventoryVO> inventoryList(int startPoint, int endPoint, String searchType, String keyword) throws Exception {
		
		Map<String,Object> data = new HashMap<>();
		data.put("startPoint", startPoint);
		data.put("endPoint", endPoint);
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return sql.selectList(namespace + ".inventoryList", data); 
	}
	
	//inventoryInfo - 게시물 정보 보기
	public InventoryVO view(String p_id) throws Exception{
		return sql.selectOne(namespace + ".view", p_id);
	}
	
	//inventoryInfo - 게시물 정보 수정
	public void modifyInventoryInfo(InventoryVO inventory) throws Exception{
		sql.update(namespace + ".modifyInventoryInfo", inventory);
	}
	
	//inventoryInfo - 게시물 내용 삭제
	public void deleteInventory(String p_id) throws Exception{
		sql.update(namespace + ".deleteInventory", p_id);
	}

	//전체 게시물 갯수 계산
	@Override
	public int totalcount(String searchType, String keyword) throws Exception {
		
		Map<String,String> data = new HashMap<>();
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return sql.selectOne(namespace + ".totalCount", data);
	}

}
