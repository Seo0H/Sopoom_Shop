package com.sopoom.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopoom.dto.ProductVO;
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
	
	//카테고리
	@GetMapping("/product/category")
	public void getFrame(Model model, @RequestParam("category") String category) throws Exception{
		List<ProductVO> product = service.selCategory(category);
		model.addAttribute("category",category);
		model.addAttribute("list",product);
	}
	
}
