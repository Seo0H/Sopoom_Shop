package com.sopoom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopoom.dao.ParchaseDAO;
import com.sopoom.dto.OrderVO;
import com.sopoom.dto.OrderedItemVO;
import com.sopoom.dto.ShippingVO;

@Service
public class ParchaseServiceImpl implements ParchaseService {
	
	@Autowired
	ParchaseDAO dao;
	
	//주문 번호 생성(랜덤) 및 중복 검사
	@Override
	public boolean orderCodeDuplCheck(String orderID) {
		return dao.orderCodeDuplCheck(orderID);
	}
	
	//주문 데이터 저장(주문번호=>orderID, uid, 총 가격, 일시)
	@Override
	public void saveOrder(OrderVO orderVO) {
		dao.saveOrder(orderVO);
	}
	
	//주문 목록 데이터 저장(주문번호, 품목id, 수량)
	@Override
	public void saveOrderedItem(OrderedItemVO orderVO) {
		// TODO Auto-generated method stub
		
	}
	
	//배송 번호 생성(랜덤) 및 중복 검사
	@Override
	public boolean createShipCode(String shipCode) {
		return true;
	}
	
	//배송 데이터 저장(주문번호==배송id?, 이름, 우편번호, 주소, 번호, status)
	@Override
	public void saveShipping(ShippingVO shpiipingVO) {
		dao.saveShipping(shpiipingVO);
	}

}
