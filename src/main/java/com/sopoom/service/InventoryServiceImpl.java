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
}
