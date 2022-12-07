package com.sopoom.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.sopoom.dto.LikeVO;
import com.sopoom.dto.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.sopoom.mappers.product";
	
	//게시물 목록 보기
	@Override
	public List<ProductVO> list() throws Exception {
		return sql.selectList(namespace + ".list"); 
	}
	
	// 제품 상세 보기
	@Override
	public ProductVO product(String p_id) throws Exception {
		return sql.selectOne(namespace + ".product", p_id);
	}

	@Override
	public ProductVO getPrdLikeVal(String p_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPrdctLike(ProductVO productVO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int prdctLikeCancel(ProductVO productVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	//좋아요/싫어요 확인 가져 오기
//		@Override
//		public LikeVO likeCheckView(int seqno,String userid) throws Exception {
//			
//			Map<String,Object> data = new HashMap<>();
//			data.put("seqno", seqno);
//			data.put("userid", userid);
//			return sql.selectOne(namespace + ".likeCheckView", data);
//		}
//		
//		//좋아요/싫어요 갯수 수정하기
//		public void boardLikeUpdate(int seqno, int likecnt, int dislikecnt) throws Exception {
//			Map<String,Integer> data = new HashMap<>();
//			data.put("seqno", seqno);
//			data.put("likecnt", likecnt);
//			data.put("dislikecnt", dislikecnt);
//			sql.update(namespace + ".boardLikeUpdate", data);
//		}
//		
//		//좋아요/싫어요 확인 등록하기
//		public void likeCheckRegistry(Map<String,Object> map) throws Exception {
//			sql.insert(namespace + ".likeCheckRegistry", map);
//		}
//		
//		//좋아요/싫어요 확인 수정하기
//		public void likeCheckUpdate(Map<String,Object> map) throws Exception {
//			sql.update(namespace + ".likeCheckUpdate", map);
//		}
}
