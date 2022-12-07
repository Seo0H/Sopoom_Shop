package com.sopoom.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopoom.dto.ProductVO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sopoom.dto.LikeVO;
import com.sopoom.service.LikeService;

import com.sopoom.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService service; //의존성 주입
	@Autowired
	LikeService likeService; // 의존성 주입
	
	Logger log = LoggerFactory.getLogger(ProductController.class);
	
	//상품 목록 보기
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

	//상품 상세 보기
	@GetMapping("/product/productDetail")
	public ModelAndView seeProduct(Model model, @RequestParam("id") String p_id, ModelAndView mav , HttpSession session) throws Exception{
		log.info("p_id "+p_id);
		ProductVO product = service.product(p_id);
		model.addAttribute("product", product);
		
		// 해당 상품 찜 여부 확인용 데이터 가져오기
	    log.info("prdLikeVal...");
	    mav.addObject("prdLikeVal");
	    
	    LikeVO likeVO = new LikeVO();
	    likeVO.setP_id(product.getP_id());

//	    likeVO.setUserid((String) session.getAttribute("userID"));
	    likeVO.setUserid("user");
	    if( likeService.dibs(likeVO) == 1 ) {
	    	log.info("찜 함");
	    	model.addAttribute("btn_src", "/resources/img/afterDibs.png");
		}
		else {
			log.info("찜 안함");
			log.info(likeVO.getP_id());
			model.addAttribute("btn_src", "/resources/img/beforeDibs.png");
		}

	    return mav;
	}
	
	//찜 관리
		@ResponseBody
		@PostMapping(value = "/ShopC/addLike")
		public String addLike(@RequestParam("p_id") String pID, HttpSession session) throws Exception {
			
			//String userID = (String) session.getAttribute("userID");
			String userID ="user";			
			LikeVO likeVO = new LikeVO();
			
			likeVO.setP_id(pID);
			likeVO.setUserid(userID);

			if( likeService.dibs(likeVO) == 1 ) {
				
				likeService.prdctLikeCancel(likeVO);
				System.out.println("EMPTY");
				return ("empty");
			}
			else {
				likeService.setPrdctLike(likeVO);
				System.out.println("FULL");
				//return("full");
				return null;
			}
	}
	
}

