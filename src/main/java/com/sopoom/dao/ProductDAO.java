package com.sopoom.dao;

import java.util.List;
import java.util.Map;

import com.sopoom.dto.ProductVO;
import com.sopoom.dto.FileVO;

public interface ProductDAO {

	//게시물 목록보기
	public List<ProductVO> list() throws Exception;

	//전체 게시물 갯수 계산
	public int totalCount(String searchType,String keyword) throws Exception;
	
	//게시물 내용 보기
	public ProductVO view(int seqno) throws Exception;

	//게시물 번호 구하기 - 시퀀스의 Last Number 사용
	public int getSeqnoWithLastNumber() throws Exception;
	
	//게시물 번호 구하기 - 시퀀스의 nexval 사용
	public int getSeqnoWithNextval() throws Exception;
	
	//게시물 이전 보기
	public int pre_seqno(int seqno,String searchType, String keyword) throws Exception;
	
	//게시물 다음 보기
	public int next_seqno(int seqno,String searchType, String keyword) throws Exception;
	
	//admin - 상품 등록
	public void productReg(ProductVO board) throws Exception;
	
	//admin - 중복 상품 이름 체크
	public int pidCheck(String p_id) throws Exception;
	
	//파일 업로드 정보 등록
	public void fileInfoRegistry(Map<String,Object> fileInfo) throws Exception;

	//게시글 내에서 업로드된 파일 목록 보기
	public List<FileVO> fileListView(int seqno) throws Exception;
	
	//게시물 수정
	public void modify(ProductVO board) throws Exception;
	
	//게시물 삭제
	public void delete(int seqno) throws Exception;

}
