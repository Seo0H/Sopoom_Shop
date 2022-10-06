package com.sopoom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.sopoom.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService service; //의존성 주입
	
	Logger log = LoggerFactory.getLogger(MemberController.class);
	
	//사용자 목록 보기
	@GetMapping("/admin/member/allMemberInfoView")
	public void GetAllMemberInfoView(Model model) throws Exception{
				
		model.addAttribute("allMemberInfoView", service.allMemberInfoView());
	}

	
}
