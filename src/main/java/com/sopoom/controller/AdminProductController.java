package com.sopoom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sopoom.dto.ProductVO;
import com.sopoom.service.AdminProductService;

@Controller
public class AdminProductController {

	@Autowired
	AdminProductService service; //의존성 주입
	
	Logger log = LoggerFactory.getLogger(AdminProductController.class);
	
	//게시물 등록 화면 보기
	@GetMapping("/admin/Product/productReg")
	public void GetProductReg() { }
	
	//상품 등록
	@PostMapping("/admin/Product/productReg")
	public String PostProductReg(ProductVO board) throws Exception{
		
		service.productReg(board);
		
		return "redirect:/product/list";
	}
	
	//상품 이름 중복 체크
	@GetMapping("/admin/Product/pidCheck")
	public void GetpidCheck(Model model, @RequestParam("p_id") String p_id) throws Exception{
		model.addAttribute("pidCheck", service.pidCheck(p_id));
	}

}
