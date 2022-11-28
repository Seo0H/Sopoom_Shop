package com.sopoom.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	//사용자 비밀번호 찾기 보기
	@RequestMapping(value="/findPW",method=RequestMethod.GET)
	public void getfindPW() { } 
	
	//사용자 비밀번호 찾기 (변경하기) 
	@RequestMapping(value="/findPW",method=RequestMethod.POST)
	public String postSearchPW(MemberVO member, RedirectAttributes rttr) { 
		
		//조건에 해당하는 사용자가 아닐 경우
		if(service.findPWfindUser(member) == 0) {
			rttr.addFlashAttribute("msg", "USER_NOT_FOUND");
			return "redirect:/login/findPW";
			
		}
		
		
		// 랜덤한 문자열 생성
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
					
		Random random = new Random();
		

		String tempPW = random.ints(leftLimit,rightLimit + 1)
		  .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		  .limit(targetStringLength)
		  .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		  .toString();
		 
		member.setPassword(pwdEncoder.encode(tempPW));
		
		service.findPWtempPW(member);
		
		return "redirect:/login/pwView?userID=" + member.getUserID() + "&tempPW=" + tempPW;		
	} 

	//찾은 비밀번호 보기
	@RequestMapping(value="/pwView",method=RequestMethod.GET)
	public void postSearchPW(@RequestParam("userID") String userid,@RequestParam("tempPW") String tempPW, Model model) {
				
		model.addAttribute("userid", userid);
		model.addAttribute("tempPW", tempPW);
		
	}

}
