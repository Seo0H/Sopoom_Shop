package com.sopoom.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopoom.dto.OrderVO;
import com.sopoom.dto.OrderedItemVO;
import com.sopoom.dto.ShippingVO;

@Repository
public class ParchaseDAOImpl implements ParchaseDAO {
	@Autowired
	SqlSession sql;
	
	private static String namespace ="com.sopoom.mappers.Purchase.inventory";

		//주문 번호 중복 검사
		@Override
		public boolean orderCodeDuplCheck(String orderID) {
			return sql.selectOne(namespace+".orderCodeDuplCheck", orderID);
		}
		
		//주문 데이터 저장(주문번호=>orderID, uid, 총 가격, 일시)
		@Override
		public void saveOrder(OrderVO orderVO) {
			sql.insert(namespace+ ".saveOrder", orderVO);
		}
		
		//주문 목록 데이터 저장(주문번호, 품목id, 수량)
		@Override
		public void saveOrderedItem(OrderedItemVO orderedItemVO) {
			sql.insert(namespace+ ".saveOrderedItem", orderedItemVO);
			
		}
		
		//배송 번호 생성(랜덤) 및 중복 검사
		@Override
		public boolean createShipCode(String shipCode) {
			return true;
		}
		
		//배송 데이터 저장(주문번호==배송id?, 이름, 우편번호, 주소, 번호, status)
		@Override
		public void saveShipping(ShippingVO shpiipingVO) {
			sql.insert(namespace+ ".saveShipping", shpiipingVO);
			
		}

}
