package com.sopoom.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopoom.dao.AdminInventoryDAO;
import com.sopoom.dto.InventoryVO;

@Service
public class AdminInventoryServiceImpl implements AdminInventoryService {

	@Autowired
	AdminInventoryDAO dao; 
	
	//게시물 목록 보기
	@Override
	public List<InventoryVO> inventoryList(int postNum, int startPoint, int endPoint, String searchType, String keyword) throws Exception {
		
		return dao.inventoryList(postNum, startPoint,endPoint,searchType,keyword);
	}
	
	//전체 게시물 갯수 계산
	@Override
	public int totalCount(String searchType, String keyword) throws Exception {
		return dao.totalcount(searchType,keyword);
	}
		
	//inventoryInfo - 게시물 정보 보기
	public InventoryVO view(String p_id) throws Exception{
		return dao.view(p_id);
	}
	
	//inventoryInfo - 게시물 정보 수정
	public void modifyInventoryInfo(InventoryVO inventory) throws Exception{
		dao.modifyInventoryInfo(inventory);
	}
	
	//inventoryInfo - 게시물 내용 삭제
	public void deleteInventory(String p_id) throws Exception{
		dao.deleteInventory(p_id);
	}


}
