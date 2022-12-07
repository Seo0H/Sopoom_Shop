package com.sopoom.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopoom.dto.OrderVO;
import com.sopoom.dto.OrderedItemVO;
import com.sopoom.dto.ShippingVO;
import com.sopoom.service.ParchaseService;

@Controller
public class PurchaseController {

	@Autowired
	ParchaseService service;

	@PostMapping("/Purchase/purchase")
	public void postPurchase() {
	}

	@PostMapping("/Purchase/purchaseVerify")
	public String postPurchaseVerify(HttpSession session, HttpServletRequest request, OrderVO orderVO,
			OrderedItemVO orderedItemVO, ShippingVO shippingVO) throws Exception {

		String userid = (String) session.getAttribute("userID");
		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("name");
		String postcode = request.getParameter("postcode");
		String address = request.getParameter("address");
		String detailAddress = request.getParameter("detailAddress");
		String extraAddress = request.getParameter("extraAddress");

		String telno = request.getParameter("telno");
		String totalPrice = request.getParameter("totalPrice");
		int intPrice = Integer.parseInt(totalPrice);

		String[] pID = request.getParameterValues("p_id");
		String[] count = request.getParameterValues("count");

		String status = "주문 완료";

		System.out.println("PRODUCT ID 입니다: " + Arrays.toString(pID));
		System.out.println("count 입니다: " + Arrays.toString(count));
		System.out.println("intTPricd 입니다: " + intPrice);

		int oCodeCount = 0;
		int sCodeCount = 0;
		String orderID = null, shipCode = null;

		// 주문 번호 생성(랜덤) 및 중복 검사
		boolean isExist = true;

		while (isExist == true) {
			orderID = RandomStringUtils.randomAlphanumeric(10);
			isExist = service.orderCodeDuplCheck(orderID);
		}

		// 주문 데이터 저장(주문번호=>orderID, uid, 총 가격, 일시)
		orderVO.setOrderID(orderID);
		orderVO.setUserID(userid);
		orderVO.setTotalPrice(intPrice);
		service.saveOrder(orderVO);

		// 주문 아이템 저장
		for (int i = 0; i < pID.length; i++) {
			orderedItemVO.setCount(Integer.parseInt(count[i]));
			orderedItemVO.setOrderID(orderID);
			orderedItemVO.setpID(pID[i]);
			service.saveOrderedItem(orderedItemVO);
			System.out.println(
					"count:" + Integer.parseInt(count[i]) + " / " + "pID: " + pID[i] + " / " + "orderID: " + orderID);
		}

		// 배송 번호 생성(랜덤) 및 중복 검사
		shipCode = RandomStringUtils.randomNumeric(10);

		// 배송 데이터 저장
		shippingVO.setShipID(shipCode);
		shippingVO.setOrderID(orderID);
		shippingVO.setName(name);
		shippingVO.setPostcode(postcode);
		shippingVO.setAddress(address);
		shippingVO.setDetailAddress(detailAddress);
		shippingVO.setExtraAddress(extraAddress);
		shippingVO.setTelno(telno);
		shippingVO.setUserID(userid);
		shippingVO.setStatus(status);
		service.saveShipping(shippingVO);

		// 카트 초기화 부분
		Map<String, Object> data = new HashMap<>();
		data.put("userid", userid);
		data.put("p_idList", pID);
		service.delOrderCart(data);

		return "redirect:/Purchase/purchase_fin?orderCode=" + orderID + "&totalPrice=" + intPrice;
	}

	@GetMapping("/Purchase/purchase_fin")
	public void getPurchaseFine(Model model, @RequestParam String orderCode, @RequestParam int totalPrice) {

		DecimalFormat df = new DecimalFormat("###,###");
		System.out.println(orderCode + " / " + df.format(totalPrice) + "원");

		model.addAttribute("orderCode", orderCode);
		model.addAttribute("totalPrice", df.format(totalPrice));
	}

	@PostMapping("/Purchase/purchase_fin")
	public void postPurchaseFine() {
	}

	

}
