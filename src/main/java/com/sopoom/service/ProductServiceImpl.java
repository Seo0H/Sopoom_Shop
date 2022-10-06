package com.sopoom.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopoom.dao.ProductDAO;
import com.sopoom.dto.ProductVO;
import com.sopoom.dto.FileVO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO dao; 
	
	//게시물 목록 보기
	@Override
	public List<ProductVO> list() throws Exception {
		
		return dao.list();
	}
	
	//전체 게시물 갯수 계산
	@Override
	public int totalCount(String searchType,String keyword) throws Exception{
		return dao.totalCount(searchType, keyword);
	}

	//게시물 내용 보기
	@Override
	public ProductVO view(int seqno) throws Exception {
		
		return dao.view(seqno);
	}

	//admin - 상품 등록 
	@Override
	public void productReg(ProductVO board) throws Exception {
		dao.productReg(board);		
	}
	
	//admin - 상품 이름 중복 체크 
	@Override
	public int pidCheck(String p_id) throws Exception{
		return dao.pidCheck(p_id);
	}

	//게시물 번호 구하기 - 시퀀스의 Last Number 사용
	public int getSeqnoWithLastNumber() throws Exception {
		return dao.getSeqnoWithLastNumber();
	}
	
	//게시물 번호 구하기 - 시퀀스의 nexval 사용
	public int getSeqnoWithNextval() throws Exception {
		return dao.getSeqnoWithNextval();
	}

	//게시물 이전 보기
	public int pre_seqno(int seqno,String searchType, String keyword) throws Exception {
		return dao.pre_seqno(seqno, searchType, keyword);
	}
	
	//게시물 다음 보기
	public int next_seqno(int seqno,String searchType, String keyword) throws Exception {
		return dao.next_seqno(seqno, searchType, keyword);
	}
	
	//파일 업로드 정보 등록
	public void fileInfoRegistry(Map<String,Object> fileInfo) throws Exception {
		dao.fileInfoRegistry(fileInfo);
	}
	
	//게시글 내에서 업로드된 파일 목록 보기
	public List<FileVO> fileListView(int seqno) throws Exception {
		return dao.fileListView(seqno);
	}
	
	//게시물 수정
	@Override
	public void modify(ProductVO board) throws Exception {
		dao.modify(board);		
	}

	//게시물 삭제
	@Override
	public void delete(int seqno) throws Exception {
		dao.delete(seqno);		
	}
}
