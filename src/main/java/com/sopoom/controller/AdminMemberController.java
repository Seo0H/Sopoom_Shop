package com.sopoom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopoom.dto.InventoryVO;
import com.sopoom.dto.MemberVO;
import com.sopoom.service.AdminMemberService;
import com.sopoom.util.Page;

@Controller
public class AdminMemberController {

	@Autowired
	AdminMemberService service; //의존성 주입
	
	Logger log = LoggerFactory.getLogger(AdminMemberController.class);
	
	//사용자 목록 보기
	@GetMapping("/admin/member/allMemberInfoView")
	public void GetAllMemberInfoView(Model model, @RequestParam(name="page") int pageNum, 
			@RequestParam(name="searchType", defaultValue="orderID", required=false) String searchType, 
			@RequestParam(name="keyword", defaultValue="", required=false) String keyword ) throws Exception{
		
		int listCount = 5;
		int postNum = 5; //한 페이지에 보여질 게시물 목록 갯수
		int startPoint = (pageNum -1)*postNum; //테이블에서 읽어 올 행의 위치
		int endPoint = postNum*pageNum;
	
		Page page = new Page();
		int totalCount = service.totalCount(searchType, keyword);
				
		log.info("keyword "+keyword);
		log.info(startPoint + "  " + endPoint);
		
		model.addAttribute("allMemberInfoView", service.allMemberInfoView(postNum, startPoint, endPoint, searchType, keyword));
		model.addAttribute("page", pageNum);
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		model.addAttribute("pageListView", page.getPageMember(pageNum, postNum, listCount, totalCount, searchType, keyword));
	}

	//사용자 개인 정보 보기
	@GetMapping("/admin/member/memberInfoView")
	public void GetMemberInfoView(Model model,
			@RequestParam("userID") String userID) throws Exception{
				
		model.addAttribute("memberInfoView", service.memberInfoView(userID));
	}	
	
	//회원 탈퇴 처리
	@GetMapping("/admin/member/deleteMember")
	public String GetDeleteMember(@RequestParam("userID") String userID) throws Exception{

		service.deleteMember(userID);
		
		return "redirect:/admin/member/allMemberInfoView";
	}
	
	//회원 정보 수정
	@PostMapping("/admin/member/modifyMember")
	public String PostModifyMemberInfo(MemberVO member) throws Exception{
		
		service.modifyMemberInfo(member);
		return "redirect:/admin/member/memberInfoView?userID="+ member.getUserID();
	}
	
}
