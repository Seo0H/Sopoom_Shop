package com.sopoom.dao;

import java.util.Map;

import com.sopoom.dto.OrderVO;
import com.sopoom.dto.OrderedItemVO;
import com.sopoom.dto.ShippingVO;

public interface ParchaseDAO  {
	
		//주문 번호 중복 검사
		public boolean orderCodeDuplCheck(String orderID);
		
		//주문 데이터 저장(주문번호=>orderID, uid, 총 가격, 일시)
		public void saveOrder(OrderVO orderVO);
		
		//주문 목록 데이터 저장(주문번호, 품목id, 수량)
		public void saveOrderedItem(OrderedItemVO orderVO);
		
		//배송 번호 생성(랜덤) 및 중복 검사
		public boolean createShipCode(String shipCode);
		
		//배송 데이터 저장(주문번호==배송id?, 이름, 우편번호, 주소, 번호, status)
		public void saveShipping(ShippingVO shpiipingVO);
		
		//주문 상품 삭제
		public void delOrderCart(Map<String,Object> data) throws Exception;

}
