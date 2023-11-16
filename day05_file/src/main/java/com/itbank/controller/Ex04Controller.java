package com.itbank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.Ex04DTO;
import com.itbank.service.Ex04Service;

@Controller
@RequestMapping("/ex04")
public class Ex04Controller {
	
	@Autowired
	private Ex04Service ex04Service;
	
	@GetMapping
	public ModelAndView ex04() {
		ModelAndView mav = new ModelAndView();
		List<Ex04DTO> list = ex04Service.getList();
		mav.addObject("list", list);
		return mav;
		
	}
	
	@PostMapping
	public ModelAndView ex04(Ex04DTO dto) {
		List<MultipartFile> list = dto.getUploadFile();	// dto에서 업로드 파일 목록을 가져와서
		list.removeIf(file -> file.getSize() == 0);		// 크기가 0인것은 모두 없앤다		
		dto.setUploadFile(list);						// 수정된 리스트를 다시 dto에 세팅하고		
		System.out.println(dto);						// dto를 출력
		
		int row = ex04Service.uploadMultipleFile(dto);
		System.out.println(row);
		
//		1) forEach를 이용하여 신규 리스트에 추가하기
//		List<String> fileNameList = new ArrayList<String>(); 
//		list.forEach(file -> fileNameList.add(file.getOriginalFilename()));	
//		System.out.println("fileNameList : " + fileNameList);
		
//		2) stream().map() 을 이용하여 특정 속성만 남기기
//		List<String> fileNameList = list.stream()
//										.map(file -> file.getOriginalFilename())
//										.collect(Collectors.toList());		
//		System.out.println("fileNameList : " + fileNameList);
		
		ModelAndView mav = new ModelAndView("redirect:/ex04");
		return mav;		
	}
}
