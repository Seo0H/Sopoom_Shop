package com.sopoom.service;

import java.util.List;
import com.sopoom.dto.ShippingVO;

public interface AdminshippingService {

	//게시물 목록보기
	public List<ShippingVO> shippingList() throws Exception;
}
