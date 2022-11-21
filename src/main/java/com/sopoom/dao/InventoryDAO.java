package com.sopoom.dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.sopoom.dto.InventoryVO;

public interface InventoryDAO {

	//게시물 목록보기
	public List<InventoryVO> inventoryList() throws Exception;
	
	//inventoryInfo - 게시물 정보 보기
	public InventoryVO view(String p_id) throws Exception;
	
	//inventoryInfo - 게시물 정보 수정
	public void modifyInventoryInfo(InventoryVO inventory) throws Exception;
	
	//inventoryInfo - 게시물 내용 삭제
	public void deleteInventory(String p_id) throws Exception;
}
