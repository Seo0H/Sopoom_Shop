package com.sopoom.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.sopoom.dto.OrderVO;
import com.sopoom.dto.OrderedItemVO;
import com.sopoom.dto.ShippingVO;
import com.sopoom.service.ParchaseService;

@Controller
public class PurchaseController {
	
	@Autowired
	ParchaseService service;
	
	@PostMapping("/Purchase/purchase")
	public void postPurchase() {}
	
	@PostMapping("/Purchase/purchaseFine")
	public void postPurchaseFine() {}
	
	@PostMapping("/Purchase/purchaseVerify")
	public void postPurchaseVerify (HttpSession session, HttpServletRequest request,
			OrderVO orderVO, OrderedItemVO orderedItemVO, ShippingVO shippingVO) throws IOException {
		
		String userid = "admin";
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
		
		

		//getParameterValues NULL보정 부분
		String dummy1 = "";
		String dummy2 = "";

		if (pID == null) {
			pID = new String[0];
			}
			for (int i = 0; i < pID.length; i++) {
			dummy1 += pID[i] + "&nbsp";
			}

		if (count == null) {
			count = new String[0];
			}
			for (int i = 0; i < count.length; i++) {
			dummy2 += count[i] + "&nbsp";
			}
			
		System.out.println("PRODUCT ID 입니다: " + Arrays.toString(pID));
		System.out.println("count 입니다: " + Arrays.toString(count));
		System.out.println("intTPricd 입니다: " + intPrice);
		
		int oCodeCount = 0;
		int sCodeCount = 0;
		String orderID = null, shipCode = null;
		
		//주문 번호 생성(랜덤) 및 중복 검사
		boolean isExist = true;
		
		while (isExist == true) {
			orderID = RandomStringUtils.randomAlphanumeric(10);
			System.out.println("orderCode :"+ orderID);
			isExist = service.orderCodeDuplCheck(orderID);
		}
		
		//주문 데이터 저장(주문번호=>orderID, uid, 총 가격, 일시)
		orderVO.setOrderID(orderID);
		orderVO.setUserID(userid);
		orderVO.setTotalPrice(intPrice);
		service.saveOrder(orderVO);
		
		//배송 번호 생성(랜덤) 및 중복 검사
		shipCode = RandomStringUtils.randomNumeric(10);
		
		orderedItemVO.setCount(sCodeCount);
		orderedItemVO.setOrderID(orderID);
		orderedItemVO.setpID(shipCode);
		service.saveOrderedItem(orderedItemVO);
		
		//배송 데이터 저장
		shippingVO.setShipID(shipCode);
		shippingVO.setOrderID(orderID);
		shippingVO.setName(name);
		shippingVO.setPostcode(postcode);
		shippingVO.setAddress(address);
		shippingVO.setDetailAddress(detailAddress);
		shippingVO.setExtraAddress(extraAddress);
		shippingVO.setTelno(telno);
		shippingVO.setUserID(userid);

		
	}

}
