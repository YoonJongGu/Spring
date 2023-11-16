package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.model.PagingDTO;
import com.itbank.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/join")
	public ModelAndView join() {
		
		System.out.println("handle");
		
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> list = memberService.getList();
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/join")
	public String join(MemberDTO dto) {
		int row = memberService.join(dto);
		System.out.println(row != 0 ? "추가 성공" : "추가 실패");
		return "redirect:/join";
	}
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(MemberDTO user, String url, HttpSession session) {
		System.out.println("로그인 이후 이동할 주소 : " + url);
		
		MemberDTO login = memberService.login(user);
		session.setAttribute("login", login);
//		if(url == null) {
//			return "redirect:/";	 
//		}
//		else {
//			return "redirect:/" + url;
//		}
		return "redirect:" + (url == null ? "/" : url);
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/test")
	public void test() {}
	
	@GetMapping("/memberlist")
	public ModelAndView memberlist(PagingDTO dto, @RequestParam("nowPage") String nowPage) {
		ModelAndView mav = new ModelAndView();
		
		int total = memberService.cntMember();
		if(nowPage == null) {
			nowPage = "1";
		}
		dto = new PagingDTO(total, Integer.parseInt(nowPage));
		mav.addObject("paging", dto);
		mav.addObject("list", memberService.selectMember(dto));
		return mav;
	}
}
