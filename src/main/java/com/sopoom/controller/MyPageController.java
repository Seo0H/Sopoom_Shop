package com.sopoom.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.sopoom.dto.MemberVO;
import com.sopoom.service.MemberService;

@Controller
public class MyPageController {
Logger log = Logger.getLogger(CartController.class);
	
	@Autowired
	MemberService service;
	
	@GetMapping("/myPage/userMain")
	public void getUserMain (Model model,HttpSession session) {
		//String userid = session.getId();
		String userid = "admin";
		MemberVO member = service.userInfoView(userid);
		member.setUserID(userid);
		model.addAttribute("memberVO",member);
	}
}
