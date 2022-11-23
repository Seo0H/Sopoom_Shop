package com.sopoom.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sopoom.dto.MemberVO;
import com.sopoom.service.LoginService;


@Controller
@RequestMapping("/login/*")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@Autowired //비밀번호 암호화 이존성 주입
	private BCryptPasswordEncoder pwdEncoder;

	
	//사용자 등록 화면 보기
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public void getMemberRegistry() throws Exception { }
	
	//사용자 등록 처리
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String postMemberRegistry(MemberVO member) {
		
		String inputPassword = member.getPassword();
		String pwd = pwdEncoder.encode(inputPassword); 
		member.setPassword(pwd);			

		service.memberInfoRegistry(member);
		return "redirect:/";
	}
	
	//사용자 등록 시 아이디 중복 확인
	@ResponseBody
	@RequestMapping(value="/idCheck",method=RequestMethod.POST)
	public int idCheck(@RequestParam("userID") String userid) throws Exception{
		int result = service.idCheck(userid);
		
		return result;
	}
	
	//로그인 화면 보기
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public void getLogIn() { }
	
	//로그인 처리
	@RequestMapping(value="/loginCheck",method=RequestMethod.POST)
	public String postLogIn(MemberVO loginData,Model model,HttpSession session,
			RedirectAttributes rttr) {
		
		//아이디 존재 여부 확인
		if(service.idCheck(loginData.getUserID()) == 0) {
			rttr.addFlashAttribute("message", "ID_NOT_FOUND");
			return "redirect:/login/login";
		}
		
		MemberVO member = service.login(loginData.getUserID());
		
		//패스워드 확인
		if(!pwdEncoder.matches(loginData.getPassword(),member.getPassword())) {
			rttr.addFlashAttribute("message", "PASSWORD_NOT_FOUND");
			return "redirect:/login/login";
		}
		else {
			
			session.setMaxInactiveInterval(3600*7);
			session.setAttribute("userID", member.getUserID());
			session.setAttribute("username", member.getUsername());
			
			return "redirect:../";
		}
	}
	
	//로그아웃
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String getLogout(HttpSession session) {		
		session.invalidate(); //모든 세션 종료--> 로그아웃...
		return "redirect:../";
	}
	
	//사용자 아이디 찾기 보기
	@RequestMapping(value="/searchID",method=RequestMethod.GET)
	public void getSearchID() { } 
	
	//사용자 아이디 찾기 
	@RequestMapping(value="/searchID",method=RequestMethod.POST)
	public String postSearchID(MemberVO member, RedirectAttributes rttr) { 
		
		String userid = service.searchPW(member);
				
		//조건에 해당하는 사용자가 아닐 경우 
		if(userid == null ) { 
			rttr.addFlashAttribute("msg", "ID_NOT_FOUND");
			return "redirect:/member/searchID"; 
		}
		
		return "redirect:/member/IDView?userid=" + userid;		
	} 

	//찾은 아이디 보기
	@RequestMapping(value="/member/IDView",method=RequestMethod.GET)
	public void postSearchID(@RequestParam("userid") String userid, Model model) {
		
		model.addAttribute("userid", userid);
		
	}

}
