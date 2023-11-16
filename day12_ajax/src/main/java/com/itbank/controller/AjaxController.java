package com.itbank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.TestDTO;

@RestController
@CrossOrigin	// 서로 다른 출처의 요청에 대해서도 응답을 허용한다
public class AjaxController {
	
	// 컨트롤러 내부의 모든 함수는 @ResponseBody가 적용된다
	// RestController는 viewName으로 처리하지 않는다
			
	@GetMapping(value="/ex02", produces="text/html; charset=utf-8")
	public String ex02() {
		return "ex02, GET 성공";
	}
	
	// servlet-context의 annotation-driven 항목에 message-converters를 추가하여 인코딩을 잡아주면
	// produces 속성을 사용하지 않아도 한글 인코딩이 성공적으로 적용된다
	
	@PostMapping("/ex02")
	public String ex02post() {
		return "ex02, POST 성공";
	}
	
	@GetMapping("/ex04")
	public List<TestDTO> ex04() {
		List<TestDTO> list = new ArrayList<TestDTO>();
		list.add(new TestDTO("유지은", 21));
		list.add(new TestDTO("서영찬", 27));
		list.add(new TestDTO("김대현", 28));
		list.add(new TestDTO("최제석", 34));
		System.out.println(list);
		return list;
	}	
	
}
