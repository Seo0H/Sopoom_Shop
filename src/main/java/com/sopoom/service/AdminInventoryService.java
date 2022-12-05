package com.sopoom.service;

import java.util.List;
import com.sopoom.dto.InventoryVO;

public interface AdminInventoryService {

	//게시물 목록보기
	public List<InventoryVO> inventoryList(int postNum, int startPoint, int endPoint, String searchType, String keyword) throws Exception;
	
	//전체 게시물 갯수 계산
	public int totalCount(String searchType, String keyword) throws Exception;

	//inventoryInfo - 게시물 정보 보기
	public InventoryVO view(String p_id) throws Exception;
	
	//inventoryInfo - 게시물 정보 수정
	public void modifyInventoryInfo(InventoryVO inventory) throws Exception;
	
	//inventoryInfo - 게시물 내용 삭제
	public void deleteInventory(String p_id) throws Exception;

	}
