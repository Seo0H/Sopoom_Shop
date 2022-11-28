package com.sopoom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopoom.dto.ProductVO;
import com.sopoom.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService service; //의존성 주입
	
	Logger log = LoggerFactory.getLogger(ProductController.class);
	
	//상품 목록 보기
	@GetMapping("/product/list")
	public void GetList(Model model) throws Exception{
				
		model.addAttribute("list", service.list());
	}
	
	// 상품 상세 페이지로 이동
	@RequestMapping("/product/productDetail")
	public void getProduct(Model model, @RequestParam("id") String p_id) throws Exception {
		ProductVO data = service.product(p_id);
		model.addAttribute("product", data);

	}
	
	//상품 상세 보기
	@GetMapping("/product/productDetail")
	public void seeProduct(Model model, @RequestParam("id") String p_id) throws Exception{
		log.info("p_id "+p_id);
		ProductVO product = service.product(p_id);
		model.addAttribute("product", product);
	}
}
