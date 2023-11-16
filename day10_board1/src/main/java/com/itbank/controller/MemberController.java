package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.model.PagingDTO;
import com.itbank.service.MemberService;

@SessionAttributes("login")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberSerivce;
	
	@GetMapping("/member/join")
	public ModelAndView join(PagingDTO paging) {
		System.out.println(paging.getNowPage());
		ModelAndView mav = new ModelAndView();
		int total = memberSerivce.cntMember();
		if(paging.getNowPage() == 0) {
			paging.setNowPage(1);
		}
		System.out.println(total);
		System.out.println(paging.getNowPage());
		paging = new PagingDTO(total, paging.getNowPage());
		List<MemberDTO> list = memberSerivce.getList(paging);
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/member/join")
	public String join(MemberDTO dto) {
		int row = memberSerivce.join(dto);		
		System.out.println(row != 0 ? "가입 성공" : "가입 실패");
		return "redirect:/member/join";
	}
	
	@GetMapping("/member/login")
	public void login() {}
	
	@PostMapping("member/login")
	public ModelAndView login(@RequestParam HashMap<String, String> user, String url) {
		ModelAndView mav = new ModelAndView("redirect:" + (url == null ? "/" : url));
		MemberDTO login = memberSerivce.login(user);
		mav.addObject("login", login);
		return mav;
	}
	
	@GetMapping("/member/logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/member/join";
	}
	
	@GetMapping("/member/mypage/{idx}")
	public ModelAndView mypage(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/member/mypage");
		MemberDTO dto = memberSerivce.getDTO(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/member/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/member/modify");
		MemberDTO dto = memberSerivce.getDTO(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/member/modify/{idx}")
	public String modify(MemberDTO user) {
		int row = memberSerivce.modify(user);
		System.out.println(row != 0 ? "수정 성공" : "수정 실패");
		return "redirect:/member/logout";
	}
	
	@GetMapping("/member/remove/{idx}")
	public String remove(@PathVariable("idx") int idx) {
		int row = memberSerivce.remove(idx);
		System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");
		return "redirect:/member/logout";
	}
}
