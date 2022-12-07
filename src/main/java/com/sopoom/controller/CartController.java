package com.sopoom.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sopoom.dto.CartVO;
import com.sopoom.dto.DibsVO;
import com.sopoom.dto.ProductVO;
import com.sopoom.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService service;

	@GetMapping(value ="/ShopC/shoppingCart")
	public void getShoppingCart(Model model, HttpSession session) throws Exception {
		String userid = (String)session.getAttribute("userID");
		List<CartVO> cartlist = service.selectCart(userid);
		
		//장바구니에 담긴 제품 품목 개수
		int totalCount;

		if(cartlist.isEmpty()) {
			totalCount = 0;
		}else {
		
		//장바구니에 물건이 있을때만 실행
		ArrayList<String> p_idList = new ArrayList<>();
		
		for (int i = 0; i < cartlist.size(); i++) {
			p_idList.add(cartlist.get(i).getP_id());
		}
		
		List<ProductVO> productVO = service.selectCartProductInfo(p_idList);
		List<CartVO> cartVO = service.selectCart(userid);
		totalCount = cartlist.size();
		
		model.addAttribute("productVO", productVO);
		model.addAttribute("cartVO", cartVO);
		}
		
		model.addAttribute("totalCount", totalCount);
	}
	
	@ResponseBody
	@PostMapping(value ="/ShopC/selectDel")
	public void postSelectDel(HttpServletRequest request ) throws Exception {
		
		String userid = request.getParameter("userid");
		String[] p_idList = request.getParameterValues("p_id");
		
		System.out.println("Post : /ShopC/selectDel");
		System.out.println("userid: " + userid);
		System.out.println("p_idList: " +Arrays.toString(p_idList));
		
		//userid 와 p_id list 같이 넘겨야 해서 map type으로 결정
		Map<String, Object> data = new HashMap<>();
		data.put("userid", userid);
		data.put("p_idList", p_idList);
		
		service.selectDel(data);
		
	}
	
	@ResponseBody
	@PostMapping(value ="/ShopC/allDel")
	public void postallDel(HttpServletRequest request) throws Exception {
		
		String userid = request.getParameter("userid");
		service.allDel(userid);
		
	}
	
}
