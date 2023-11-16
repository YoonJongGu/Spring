package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.model.TestDTO;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/")
	public String upload(TestDTO dto) {
		System.out.println(dto);
		return "redirect:/";
	}
}
