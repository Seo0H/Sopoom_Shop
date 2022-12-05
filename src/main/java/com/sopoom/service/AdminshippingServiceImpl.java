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
	public List<ShippingVO> shippingList(int postNum, int startPoint, int endPoint, String searchType, String keyword) throws Exception {
		
		return dao.shippingList(postNum, startPoint,endPoint,searchType,keyword);
	}
	
	//전체 게시물 갯수 계산
	@Override
	public int totalCount(String searchType,String keyword) throws Exception{
		return dao.totalCount(searchType, keyword);
	}

	//수정
	@Override
	public void modifyShippingStatus(ShippingVO shipping) throws Exception{
		dao.modifyShippingStatus(shipping);
				
	}

	@Override
	public ShippingVO shippingInfo(String shipID) throws Exception {
		return dao.shippingInfo(shipID);
	}
	
	

}
