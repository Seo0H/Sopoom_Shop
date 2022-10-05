package com.sopoom.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopoom.dto.CartVO;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	SqlSession sql;
	
	private static String namespace = "com.sopoom.mappers.ShopC";

	@Override
	public int insertCart(CartVO cart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCart(CartVO cart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCart(String p_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int clearCart(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CartVO> selectAllCartList(String userid) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
