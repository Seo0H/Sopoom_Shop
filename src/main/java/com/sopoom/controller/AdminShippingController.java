package com.sopoom.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopoom.util.Page;
import com.sopoom.dto.ShippingVO;
import com.sopoom.service.AdminshippingService;

@Controller
public class AdminShippingController {

	@Autowired
	AdminshippingService service; //의존성 주입
	
	Logger log = LoggerFactory.getLogger(AdminShippingController.class);
	
	//inventory - 게시물 목록 보기
	@GetMapping("/admin/shipping/shippingList")
	public void GetShippingList(Model model, @RequestParam(name="page") int pageNum, 
			@RequestParam(name="searchType", defaultValue="orderID", required=false) String searchType, 
			@RequestParam(name="keyword", defaultValue="", required=false) String keyword ) throws Exception{
		
		int listCount = 5;
		int postNum = 5; //한 페이지에 보여질 게시물 목록 갯수
		int startPoint = (pageNum -1)*postNum + 1; //테이블에서 읽어 올 행의 위치
		int endPoint = postNum*pageNum;
	
		Page page = new Page();
		int totalCount = service.totalCount(searchType, keyword);
				
		log.info("keyword "+keyword);
		log.info("page " + pageNum);
		log.info("post " + startPoint + " " + endPoint);
		
		model.addAttribute("shippingList", service.shippingList(startPoint, endPoint, searchType, keyword));
		model.addAttribute("page", pageNum);
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		model.addAttribute("pageListView", page.getPageShipping(pageNum, postNum, listCount, totalCount, searchType, keyword));
	}

	//게시물 수정
	@GetMapping("/admin/shipping/modifyShippingStatus")
	public String PostModifyShippingList( 
			@RequestParam("ship_id") String shipID,
			@RequestParam("statusSelect") String status) throws Exception{
	
		log.info("shipID " + shipID);
		log.info("status " + status);
		
		ShippingVO ship = service.shippingInfo(shipID);
		ship.setStatus(status);
		
		log.info(ship.getStatus());
		service.modifyShippingStatus(ship);
		return "redirect:/admin/shipping/shippingList?page=1";
			
	}
}