package com.itbank.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;

@SessionAttributes("login")
@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberSerivce;
	
	@Value("classpath:agreement/agreement.txt")		// 자원의 값을 자동으로 찾아준다
	private Resource agreement;
	
	@GetMapping("/join")
	public ModelAndView join(HttpServletRequest request) throws IOException {		
		ModelAndView mav = new ModelAndView();
		File f = agreement.getFile();
		Scanner sc = new Scanner(f);
		String agreement = "";
		while(sc.hasNextLine()) {
			agreement += sc.nextLine();
			agreement += "\n";
		}
		sc.close();
		List<MemberDTO> list = memberSerivce.getList();		
		mav.addObject("list", list);
		mav.addObject("agreement", agreement);
		return mav;
	}
	
	@PostMapping("/join")
	public String join(MemberDTO dto) {
		int row = memberSerivce.join(dto);		
		System.out.println(row != 0 ? "가입 성공" : "가입 실패");
		return "redirect:/member/join";
	}
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public ModelAndView login(@RequestParam HashMap<String, String> user, String url) {
		ModelAndView mav = new ModelAndView();
		MemberDTO login = memberSerivce.login(user);
		if(login == null) {
			mav.setViewName("redirect:/member/login");
		}
		else {
			mav.setViewName("redirect:" + (url == null ? "/" : url));
			mav.addObject("login", login);
		}		
		return mav;
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/member/join";
	}
	
	@GetMapping("/mypage/{idx}")
	public ModelAndView mypage(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/member/mypage");
		MemberDTO dto = memberSerivce.getDTO(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/member/modify");
		MemberDTO dto = memberSerivce.getDTO(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/modify/{idx}")
	public String modify(MemberDTO user) {
		int row = memberSerivce.modify(user);
		System.out.println(row != 0 ? "수정 성공" : "수정 실패");
		return "redirect:/member/logout";
	}
	
	@GetMapping("/remove/{idx}")
	public String remove(@PathVariable("idx") int idx) {
		int row = memberSerivce.remove(idx);
		System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");
		return "redirect:/member/logout";
	}
}
