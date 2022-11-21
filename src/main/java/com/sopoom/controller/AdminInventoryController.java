package com.sopoom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sopoom.dto.InventoryVO;
import com.sopoom.service.InventoryService;

@Controller
public class AdminInventoryController {

	@Autowired
	InventoryService service; //의존성 주입
	
	Logger log = LoggerFactory.getLogger(AdminInventoryController.class);
	
	//inventory - 게시물 목록 보기
	@GetMapping("/admin/inventory/inventoryList")
	public void GetInventoryList(Model model) throws Exception{
				
		model.addAttribute("inventoryList", service.inventoryList());
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
	
	@PostMapping("/admin/inventory/deleteInventoryInfo")
	public String GetDeleteInventory(@RequestParam("p_id") String p_id) throws Exception{

		log.info("삭제 " + p_id);
		
		service.deleteInventory(p_id);
		
		return "redirect:/admin/inventory/inventoryList";
	}
}

