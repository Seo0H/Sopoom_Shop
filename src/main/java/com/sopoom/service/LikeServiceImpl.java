package com.sopoom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopoom.dao.LikeDAO;
import com.sopoom.dto.LikeVO;
import com.sopoom.dto.ProductVO;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	LikeDAO dao; 

	@Override
	public int dibs(LikeVO likeVO) throws Exception {
		return dao.dibs(likeVO);
	}
	
	@Override
	public List<ProductVO> getPrdLikeVal(String userid) throws Exception {
		return dao.getPrdLikeVal(userid);
	}

	@Override
	public void setPrdctLike(LikeVO LikeVO) throws Exception {
		dao.setPrdctLike(LikeVO);
		
	}

	@Override
	public void prdctLikeCancel(LikeVO LikeVO) throws Exception {
		dao.prdctLikeCancel(LikeVO);
		
	}
}
