package com.sopoom.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sopoom.dto.ProductVO;
import com.sopoom.dto.FileVO;

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
	
	@Override
	//전체 게시물 갯수 계산
	public int totalCount(String searchType,String keyword) throws Exception{
		
		Map<String,String> data = new HashMap<>();
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		return sql.selectOne(namespace + ".totalCount", data);
	}
	
	//게시물 내용 보기
	@Override
	public ProductVO view(int seqno) throws Exception {

		return sql.selectOne(namespace + ".view", seqno);
	}

	//게시물 번호 구하기 - 시퀀스의 Last Number 사용
	@Override
	public int getSeqnoWithLastNumber() throws Exception {
		
		return sql.selectOne(namespace + ".getSeqnoWithLastNumber");
	}
	
	//게시물 번호 구하기 - 시퀀스의 nexval 사용
	@Override
	public int getSeqnoWithNextval() throws Exception {
		
		return sql.selectOne(namespace + ".getSeqnoWithNextval");
	}
	
	//게시물 이전 보기
	@Override
	public int pre_seqno(int seqno,String searchType, String keyword) throws Exception {
		Map<String,Object> data = new HashMap<>();
		data.put("seqno", seqno);
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		return sql.selectOne(namespace + ".pre_seqno", data);		
	}
	
	//게시물 다음 보기
	@Override
	public int next_seqno(int seqno,String searchType, String keyword) throws Exception {
		Map<String,Object> data = new HashMap<>();
		data.put("seqno", seqno);
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		return sql.selectOne(namespace + ".next_seqno", data);
	}
	
	//admin - 상품 등록
	@Override
	public void productReg(ProductVO board) throws Exception {
		sql.insert("com.sopoom.mappers.admin.Product" + ".productReg", board);
	}
	
	//admin - 중복 상품 이름 체크
	public int pidCheck(String p_id) throws Exception {	
		return sql.selectOne("com.sopoom.mappers.admin.Product" + ".pidCheck", p_id);
	}

	//파일 업로드 정보 등록
	public void fileInfoRegistry(Map<String,Object> fileInfo) throws Exception {
		sql.insert(namespace + ".fileInfoRegistry", fileInfo);
	}
	
	//게시글 내에서 업로드된 파일 목록 보기
	public List<FileVO> fileListView(int seqno) throws Exception {
		return sql.selectList(namespace + ".fileListView", seqno);
	}
	
	//게시물 수정
	@Override
	public void modify(ProductVO board) throws Exception {
		sql.update(namespace + ".modify", board);
		
	}

	//게시물 삭제
	@Override
	public void delete(int seqno) throws Exception {
		sql.delete(namespace + ".delete", seqno);
		
	}
}
