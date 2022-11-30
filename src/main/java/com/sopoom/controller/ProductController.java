package com.sopoom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView seeProduct(Model model, @RequestParam("id") String p_id, ProductVO ProductVO, ModelAndView mav) throws Exception{
		log.info("p_id "+p_id);
		ProductVO product = service.product(p_id);
		model.addAttribute("product", product);
		
		// 해당 상품 찜 여부 확인용 데이터 가져오기
	    log.info("prdLikeVal...");
	    mav.addObject("prdLikeVal");

	    return mav;
	}
	
	// 상품 상세페이지 찜하기 기능
	@Transactional(rollbackFor = Exception.class)
	@PostMapping("/product/productDetail/")
	public ResponseEntity<String> prdctLike(@RequestBody ProductVO ProductVO) {
	    ResponseEntity<String> entity = null;

	    log.info("prdctLike...");
	    try {
	        ProductService.setPrdctLike(ProductVO);
	        entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }

	    return entity;
	}

	// 상품 상세페이지 찜취소 기능
	@Transactional(rollbackFor = Exception.class)
	@DeleteMapping("/prdct/{prdct_id}")
	public ResponseEntity<String> prdctLikeCancel(ProductVO ProductVO) {
	    ResponseEntity<String> entity = null;

	    log.info("prdctLikeCancel...");
	    try {
	        ProductService.prdctLikeCancel(ProductVO);
	        entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }

	    return entity;
	}
}

