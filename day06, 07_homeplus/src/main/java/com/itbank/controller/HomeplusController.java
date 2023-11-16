package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.HomeplusDTO;
import com.itbank.service.HomeplusService;

@Controller
public class HomeplusController {
	
	@Autowired
	private HomeplusService homeplusService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<HomeplusDTO> list = homeplusService.getList();
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/list")
	public ModelAndView list(@RequestParam HashMap<String, String> param) {
		ModelAndView mav = new ModelAndView();
		System.out.println(param.get("keyword"));
		System.out.println(param.get("order"));
		List<HomeplusDTO> list = homeplusService.getListByCondition(param);
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(int idx) {
		ModelAndView mav = new ModelAndView();
		HomeplusDTO dto = homeplusService.getDTO(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/add")
	public void insert() {}
	
	@PostMapping("/add")
	public String insert(HomeplusDTO dto) {
		MultipartFile thumbnail = dto.getThumbnail().getSize() == 0 ? null : dto.getThumbnail();
		MultipartFile reviewImage = dto.getReviewImage().getSize() == 0 ? null : dto.getReviewImage();
		dto.setThumbnail(thumbnail);
		dto.setReviewImage(reviewImage);
		int row = homeplusService.add(dto);
		System.out.println(row == 1 ? "추가 성공" : "추가 실패");
		return "redirect:/list";
	}
	
	@GetMapping("/modify")
	public ModelAndView modify(int idx) {
		ModelAndView mav = new ModelAndView();
		HomeplusDTO dto = homeplusService.getDTO(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/modify")
	public String modify(HomeplusDTO dto) {
		MultipartFile thumbnail = dto.getThumbnail().getSize() == 0 ? null : dto.getThumbnail();
		MultipartFile reviewImage = dto.getReviewImage().getSize() == 0 ? null : dto.getReviewImage();
		dto.setThumbnail(thumbnail);
		dto.setReviewImage(reviewImage);
		int row = homeplusService.modify(dto);
		System.out.println(row == 1 ? "수정 성공" : "수정 실패");
		return "redirect:/list";
	}
	
	@GetMapping("/delete")
	public String delete(int idx) {
		int row = homeplusService.remove(idx);
		System.out.println(row == 1 ? "삭제 성공" : "삭제 실패");
		return "redirect:/list";
	}
}
