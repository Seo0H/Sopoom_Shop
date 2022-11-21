package com.sopoom.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopoom.dao.InventoryDAO;
import com.sopoom.dto.InventoryVO;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryDAO dao; 
	
	//게시물 목록 보기
	@Override
	public List<InventoryVO> inventoryList() throws Exception {
		
		return dao.inventoryList();
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
