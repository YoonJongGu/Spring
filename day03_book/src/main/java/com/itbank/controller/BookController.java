package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BookDTO;
import com.itbank.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<BookDTO> list = bookService.getList();
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/list")
	public ModelAndView search(String search) {
		ModelAndView mav = new ModelAndView();
		List<BookDTO> list = bookService.getListByName(search);
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public String add(BookDTO dto) {
		int row = bookService.add(dto);		
		System.out.println(row != 0 ? "추가 성공" : "추가 실패");
		return "redirect:/list";
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(int idx) {
		ModelAndView mav = new ModelAndView();
		BookDTO dto = bookService.detail(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/modify")
	public ModelAndView modify(int idx) {
		ModelAndView mav = new ModelAndView();
		BookDTO dto = bookService.detail(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/modify")
	public String modify(BookDTO dto) {
		int row = bookService.modify(dto);
		System.out.println(row != 0 ? "수정 성공" : "수정 실패");
		return "redirect:/list";
	}
	
	@GetMapping("/delete")
	public String delete(int idx) {
		int row = bookService.delete(idx);
		System.out.println(row != 0 ? "삭제 성공" : "삭제 실패");
		return "redirect:/list";
	}
}
