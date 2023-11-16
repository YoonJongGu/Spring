package com.itbank.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.service.AjaxService;

@RestController
public class AjaxController {
	
	@Autowired
	private AjaxService ajaxService;
	
	@GetMapping("/getMidFcst")
	public String getMidFcst() throws IOException {
		String json = ajaxService.getMidFcst();
		System.out.println(json);
		return json;
	}
	
	@GetMapping("/air")
	public String getAirInfo() throws IOException {
		String json = ajaxService.getAirInfo();
		System.out.println(json);
		return json;
	}
	
	@GetMapping("/COVID-19")
	public String getCOVID() throws IOException {
		String json = ajaxService.getCOVID();
		System.out.println(json);
		return json;
	}
}
