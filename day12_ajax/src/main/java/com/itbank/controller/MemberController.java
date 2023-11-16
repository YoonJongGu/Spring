package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;	
	
	@GetMapping("/list/data")	
	public List<MemberDTO> dataList() {
		List<MemberDTO> list = memberService.getList();
		return list;		
	}
}
