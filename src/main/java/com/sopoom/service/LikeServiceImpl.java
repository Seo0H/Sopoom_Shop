package com.sopoom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopoom.dao.LikeDAO;
import com.sopoom.dto.LikeVO;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	LikeDAO dao; 

	@Override
	public int dibs(LikeVO likeVO) throws Exception {
		return dao.dibs(likeVO);
	}
	
	@Override
	public LikeVO getPrdLikeVal(String p_id, String userid) throws Exception {
		return dao.getPrdLikeVal(p_id);
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
