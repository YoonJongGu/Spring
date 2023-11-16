package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.Ex04DTO;

@Controller
@RequestMapping("/ex04")
public class Ex04Controller {
	
	@GetMapping
	public void abcd() {}
	// 컨트롤러의 함수 이름은 개발자가 구분하기 쉬운 이름이면 된다
	// 컨트롤러의 함수 이름은 viewName에 전혀 영향을 주지 않는다
	
	@PostMapping
	public ModelAndView ex04(@ModelAttribute("test") Ex04DTO user) {	// 스프링 커맨드 객체 활용
		ModelAndView mav = new ModelAndView("ex04-result");		
//		mav.addObject("user", user);
		// @ModelAttribute를 사용하면 파라미터로 넘어온 데이터를 test라는 이름으로 어트리뷰트에 바로 추가한다
//		mav.addObject("test", user);	
		return mav;		
	}
}
