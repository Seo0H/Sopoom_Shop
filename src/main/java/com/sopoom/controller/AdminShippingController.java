package com.sopoom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sopoom.service.AdminshippingService;

@Controller
public class AdminShippingController {

	@Autowired
	AdminshippingService service; //의존성 주입
	
	Logger log = LoggerFactory.getLogger(AdminShippingController.class);
	
	//inventory - 게시물 목록 보기
	@GetMapping("/admin/shipping/shippingList")
	public void GetShippingList(Model model) throws Exception{
				
		model.addAttribute("shippingList", service.shippingList());
	}}
