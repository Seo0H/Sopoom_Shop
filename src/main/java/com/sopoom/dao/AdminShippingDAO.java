package com.sopoom.dao;

import java.util.List;

import com.sopoom.dto.ShippingVO;

public interface AdminShippingDAO {

	//배송 목록보기
		public List<ShippingVO> shippingList() throws Exception;
	
}
