package com.itbank.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbank.model.BlogDTO;
import com.itbank.service.BlogService;

@Controller
public class BlogController {
	
	@Autowired private BlogService blogService;
	private ObjectMapper objectMapper = new ObjectMapper();

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/")
	public String upload(BlogDTO dto) throws IllegalStateException, IOException {
		System.out.println(dto);
		int row = blogService.insert(dto);
		return "redirect:/";
	}
	
	
	@GetMapping("/getBlog/{offset}")
	@ResponseBody
	public String getBlog(@PathVariable("offset") int offset) throws JsonProcessingException {
		String json = objectMapper.writeValueAsString(blogService.getBlog(offset));
		return json;
	}
	
	@GetMapping("/getImages/{idx}")
	@ResponseBody
	public List<String> getImages(@PathVariable("idx") int idx) {
		List<String> json = blogService.getImages(idx);
		return json;
	}
}
