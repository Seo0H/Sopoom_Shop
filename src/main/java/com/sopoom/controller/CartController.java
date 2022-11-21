package com.sopoom.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sopoom.dto.CartVO;
import com.sopoom.dto.ProductVO;
import com.sopoom.service.CartService;

@Controller
public class CartController {
	
	Logger log = Logger.getLogger(CartController.class);
	
	@Autowired
	CartService service;
	
	@GetMapping("/ShopC/shoppingCart")
	public void getShoppingCart(Model model,HttpSession session) throws Exception{
		//String userid = session.getId();
		String userid = "seo123";
		List<CartVO> cartlist = service.selectCart(userid);
		
		ArrayList<String> p_idList = new ArrayList<>();
		for(int i=0; i< cartlist.size(); i++) {
			
//			log.info(i+"번째 카트 p_id :" + cartlist.get(i).getP_id());
			p_idList.add(cartlist.get(i).getP_id());			
		}
		
		List<ProductVO> productVO = service.selectCartProductInfo(p_idList);
		List<CartVO> cartVO = service.selectCart(userid);
		
		int totalCount = cartlist.size();		
//		log.info("카트 totalCount :" + totalCount);
//		log.info("카트에 담긴 제품 :" + productVO.get(0).getP_name());

		model.addAttribute("productVO", productVO);
		model.addAttribute("cartVO", cartVO);
		model.addAttribute("totalCount", totalCount);
	}
}
