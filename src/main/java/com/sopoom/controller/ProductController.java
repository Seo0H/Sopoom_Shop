package com.sopoom.controller;

import java.io.File;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sopoom.dto.ProductVO;
import com.sopoom.service.ProductService;
import com.sopoom.util.Page;

@Controller
public class ProductController {

	@Autowired
	ProductService service; //의존성 주입
	
	Logger log = LoggerFactory.getLogger(ProductController.class);
	
	//게시물 목록 보기
	@GetMapping("/product/list")
	public void GetList(Model model) throws Exception{
				
		model.addAttribute("list", service.list());
	}

	//게시물 내용 보기
	@GetMapping("/board/view")
	public void GetView(Model model,HttpSession session, @RequestParam("seqno") int seqno, @RequestParam(name="page") int pageNum,
			@RequestParam(name="searchType", defaultValue="title", required=false) String searchType, 
			@RequestParam(name="keyword", defaultValue="", required=false) String keyword) throws Exception{
		
		ProductVO board = service.view(seqno);
		
		model.addAttribute("view", board);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		model.addAttribute("pre_seqno", service.pre_seqno(seqno, searchType, keyword));
		model.addAttribute("next_seqno",service.next_seqno(seqno, searchType, keyword));
		model.addAttribute("fileListView", service.fileListView(seqno));
	}
	
	//게시물 등록 화면 보기
	@GetMapping("/board/write")
	public void GetWrite() { }
	
	//첨부 파일 있는 게시물 등록
	@PostMapping("/board/writeWithFile")
	public String PostWriteWithFile(ProductVO board, HttpServletRequest request) throws Exception{
		
		log.info("<-------------- 첨부 파일 있음 ------------------->");
		service.write(board);
		
		return "redirect:/board/list?page=1";
	}

	//첨부 파일 없는 게시물 등록
	@PostMapping("/board/write")
	public String PostWrite(ProductVO board) throws Exception{
		
		log.info("<-------------- 첨부 파일 없음 ------------------->");
		
		service.write(board);
		
		return "redirect:/board/list?page=1";
	}
	
	//파일 업로드
	@ResponseBody
	@PostMapping("/board/fileUpload")
	public void postFileUpload(@RequestParam("SendToFileList") List<MultipartFile> multipartFile, 
			@RequestParam("kind") String kind,@RequestParam(name="seqno", defaultValue="0", required=false) int seqno,
			HttpSession session) throws Exception{
		
		log.info("파일 전송...");
		String path = "c:\\Repository\\file\\"; 
		String userid = (String)session.getAttribute("userid"); 
		if(kind.equals("I")) 
			seqno = service.getSeqnoWithNextval();
					
		File targetFile = null; 
		
		Map<String,Object> fileInfo = null;
		
		for(MultipartFile mpr:multipartFile) {
			
			String org_filename = mpr.getOriginalFilename();	
			String org_fileExtension = org_filename.substring(org_filename.lastIndexOf("."));	
			String stored_filename = UUID.randomUUID().toString().replaceAll("-", "") + org_fileExtension;	
			long filesize = mpr.getSize() ;
			
			log.info("org_filename={}", org_filename);
			log.info("stored_filename={}", stored_filename);
			
			targetFile = new File(path + stored_filename);
			mpr.transferTo(targetFile);
			
			fileInfo = new HashMap<>();
			fileInfo.put("org_filename",org_filename);
			fileInfo.put("stored_filename", stored_filename);
			fileInfo.put("filesize", filesize);
			fileInfo.put("seqno", seqno);
			fileInfo.put("userid", userid);
	
			service.fileInfoRegistry(fileInfo);

		}
	}
	
	//게시물 수정 화면 보기
	@GetMapping("/board/modify")
	public void GetModify(Model model,@RequestParam("seqno") int seqno) 
			throws Exception {
		
		model.addAttribute("view", service.view(seqno));
		model.addAttribute("fileListView", service.fileListView(seqno));
	}
	
	@PostMapping("/board/modify")
	public String PostModify(ProductVO board) throws Exception{
	
		// <------------------- 과제 ------------------------> 
		// 게시물 내용 수정
		// 선택한 첨부 파일 삭제
		// 추가된 첨부 파일 업로드		
		
		return null;
	}
	
	//게시물 삭제
	@GetMapping("/board/delete")
	public String GetDelete(@RequestParam("seqno") int seqno) throws Exception{

		// <------------------- 과제 ------------------------> 
		// 게시물 삭제 시 댓글, 첨부파일, 좋아요/싫어요 정보 삭제
		//@Transaction 사용
		
		return null;
	}
}
