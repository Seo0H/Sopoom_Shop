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
import com.sopoom.service.AdminInventoryService;
import com.sopoom.util.Page;

@Controller
public class AdminInventoryController {

	@Autowired
	AdminInventoryService service; //의존성 주입
	
	Logger log = LoggerFactory.getLogger(AdminInventoryController.class);
	
	//inventory - 게시물 목록 보기
	@GetMapping("/admin/inventory/inventoryList")
	public void GetInventoryList(Model model, @RequestParam(name="page") int pageNum, 
			@RequestParam(name="searchType", defaultValue="orderID", required=false) String searchType, 
			@RequestParam(name="keyword", defaultValue="", required=false) String keyword ) throws Exception{
		
		int listCount = 5;
		int postNum = 5; //한 페이지에 보여질 게시물 목록 갯수
		int startPoint = (pageNum -1)*postNum + 1; //테이블에서 읽어 올 행의 위치
		int endPoint = postNum*pageNum;
	
		Page page = new Page();
		int totalCount = service.totalCount(searchType, keyword);
				
		log.info(keyword);
		
		model.addAttribute("inventoryList", service.inventoryList(startPoint, endPoint, searchType, keyword));
		model.addAttribute("page", pageNum);
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		model.addAttribute("pageListView", page.getPageInventory(pageNum, postNum, listCount, totalCount, searchType, keyword));
		
	}

	//inventoryInfo - 게시물 정보 보기
	@GetMapping("/admin/inventory/inventoryInfo")
	public void GetInventoryInfo(Model model,
			@RequestParam("p_id") String p_id) throws Exception{
		
		model.addAttribute("view", service.view(p_id));
	}

	//inventoryInfo - 게시물 정보 수정
	@PostMapping("/admin/inventory/inventoryInfo")
	public String PostModifyInventoryInfo(InventoryVO inventory,
			@RequestParam("p_id") String p_id,
			@RequestParam("p_amount_value") int p_amount_value) throws Exception{
		
		inventory = service.view(p_id);
		inventory.setP_unitsInStock(p_amount_value);
		
		log.info("들어옴 ");
		log.info("id " +inventory.getP_id());
		log.info("name " +inventory.getP_name());
		log.info("unitPrice " +inventory.getP_unitPrice());
		log.info("unitsInStock " +inventory.getP_unitsInStock());
		
		service.modifyInventoryInfo(inventory);
		return "redirect:/admin/inventory/inventoryInfo?p_id="+p_id;
	}
	
	//삭제
	@PostMapping("/admin/inventory/deleteInventoryInfo")
	public String GetDeleteInventory(@RequestParam("p_id") String p_id) throws Exception{

		log.info("삭제 " + p_id);
		
		service.deleteInventory(p_id);
		
		return "redirect:/admin/inventory/inventoryList";
	}
}

