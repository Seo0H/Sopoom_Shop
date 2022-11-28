package com.sopoom.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopoom.dao.AdminShippingDAO;
import com.sopoom.dto.ShippingVO;

@Service
public class AdminshippingServiceImpl implements AdminshippingService {

	@Autowired
	AdminShippingDAO dao; 
	
	//게시물 목록 보기
	@Override
	public List<ShippingVO> shippingList(int startPoint, int endPoint, String searchType, String keyword) throws Exception {
		
		return dao.shippingList(startPoint,endPoint,searchType,keyword);
	}
	
	//전체 게시물 갯수 계산
	@Override
	public int totalCount(String searchType,String keyword) throws Exception{
		return dao.totalCount(searchType, keyword);
	}

}
