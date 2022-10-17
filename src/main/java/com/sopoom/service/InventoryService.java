package com.sopoom.service;

import java.util.List;
import com.sopoom.dto.InventoryVO;

public interface InventoryService {

	//게시물 목록보기
	public List<InventoryVO> inventoryList() throws Exception;
}
