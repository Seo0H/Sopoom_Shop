package com.sopoom.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sopoom.dto.MemberVO;
import com.sopoom.service.MemberService;

@Controller
public class MyPageController {
	Logger log = Logger.getLogger(CartController.class);

	@Autowired
	MemberService service;

	@Autowired // 비밀번호 암호화 이존성 주입
	private PasswordEncoder pwdEncoder;

	// 마이페이지 Mian
	@GetMapping("/myPage/userMain")
	public void getUserMain(Model model, HttpSession session, RedirectAttributes rttr,
			@RequestParam(value = "msg", required = false, defaultValue = "") String msg) {
		String userid = (String) session.getAttribute("userID");
		MemberVO member = service.userInfoView(userid);

		rttr.addFlashAttribute("msg", msg);
		member.setUserID(userid);
		model.addAttribute("memberVO", member);
	}

	// 마이페이지 비밀번호 확인
	@PostMapping("/myPage/pwCheck")
	public String postPwCheck(Model model, HttpSession session, RedirectAttributes rttr,
			@RequestParam("password") String input_pw) throws Exception {

		String userid = (String) session.getAttribute("userID");
		String origin_pw = service.pwCheck(userid);
		String msg;

		if (pwdEncoder.matches(input_pw, origin_pw)) {
			msg = "SUCCESS";
			log.info("비밀번호가 일치합니다.");

			return "redirect:/myPage/userInfo";

		} else {
			msg = "PASSWORD_NOT_FOUND";
			log.info("비밀번호가 일치하지 않습니다.");
			rttr.addFlashAttribute("msg", msg);

			return "redirect:/myPage/userMain";
		}

	}

	// 마이페이지 info
	@GetMapping("/myPage/userInfo")
	public void getUserInfo(Model model, HttpSession session) {
		String userid = (String) session.getAttribute("userID");
		MemberVO member = service.userInfoView(userid);
		member.setUserID(userid);
		model.addAttribute("memberVO", member);
	}

	// 마이페이지: 기본 정보 수정
	@ResponseBody
	@PostMapping("/myPage/changeInfo")
	public Map<String, String> postChangeAddress(Model model, HttpSession session, @RequestBody MemberVO membervo) {

		String userid = (String) session.getAttribute("userID");
		String telno = membervo.getTelno();
		String postcode = membervo.getPostcode();
		String address = membervo.getAddress();
		String extraAddress = membervo.getExtraAddress();
		String detailAddress = membervo.getDetailAddress();

		Map<String, String> data = new HashMap<>();
		data.put("userid", userid);
		data.put("telno", telno);
		data.put("postcode", postcode);
		data.put("address", address);
		data.put("extraAddress", extraAddress);
		data.put("detailAddress", detailAddress);

		System.out.println("data:" + data);

		service.changeInfo(data);
		return data;
	}

	// 마이페이지: 비번 변경
	@PostMapping("/myPage/changePw")
	public String postChangePw(HttpSession session,
			@RequestParam("passwordchk") String new_userpassword) {

		String userid = (String) session.getAttribute("userID");
		String newPw = pwdEncoder.encode(new_userpassword);
		
		Map<String, String> data = new HashMap<>();
		data.put("userid", userid);
		data.put("password", newPw);
		
		service.pwModify(data);
		return  "redirect:/myPage/userMain";

	}

	// 마이페이지: 회원 탈퇴
	@PostMapping("/myPage/withdrawal")
	public void postWithdrawal(Model model, HttpSession session) {
		
	}

	// 마이페이지: 배송 조회
	@GetMapping("/myPage/myOrder")
	public void getMyOrder(Model model, HttpSession session) {
		String userid = (String) session.getAttribute("userID");
		Map<String,Object> data = service.myOrder(userid);
		System.out.println(data);
		
		model.addAttribute("order", data);
	}

}
