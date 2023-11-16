package com.itbank.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.Log4jService;

@Controller
public class Log4jController {
	
	@Autowired
	private Log4jService log4jServcie;
	
	@GetMapping("/ex01")
	public ModelAndView ex01() {
		ModelAndView mav = new ModelAndView();
		String version = log4jServcie.getVersion();
		mav.addObject("version", version);
		return mav;
	}
	
	@GetMapping("/ex02")
	public ModelAndView ex02() {
		ModelAndView mav = new ModelAndView();
		Date sysdate = log4jServcie.getDate();
		mav.addObject("sysdate", sysdate);
		return mav;
	}
	
	@GetMapping("/ex03")
	public ModelAndView ex03() {
		ModelAndView mav = new ModelAndView();
		List<HashMap<String, Object>> list = log4jServcie.getList();
		System.out.println(list);
		mav.addObject("list", list);
		return mav;
	}
}
