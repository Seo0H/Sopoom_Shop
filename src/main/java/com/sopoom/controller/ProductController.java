package com.sopoom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.sopoom.service.ProductService;

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
}
