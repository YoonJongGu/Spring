package com.itbank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Ex01Controller {
	
	@RequestMapping(value="/ex01", method=RequestMethod.GET)
	public void ex01() {}
	
	// 媛��옣 湲곕낯�쟻�씤 諛섑솚�삎�씠 String�씠硫�, �룷�썙�뵫�븷 jsp�쓽 �씠由꾩쓣 媛�由ы궓�떎
	// 諛섑솚�삎�씠 void�씪硫�, �슂泥�二쇱냼 臾몄옄�뿴�쓣 �솢�슜�븯�뿬 �룷�썙�뵫�븷 jsp�쓽 �씠由꾩쓣 李얜뒗�떎
	// 二쇱냼 留� �븵�쓽 /�뒗 �젣嫄고븯怨�, /WEB-INF/views/ex01.jsp 瑜� 李얠븘�꽌 �룷�썙�뱶�븳�떎
	
	// 媛숈� 二쇱냼�씪�룄 �슂泥� 硫붿꽌�뱶�뿉 �뵲�씪�꽌 �꽌濡� �떎瑜� �옉�룞�쑝濡� 援щ텇�븷 �닔 �엳�떎
	
	@RequestMapping(value="/ex01", method=RequestMethod.POST)
	public String ex01(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String adult = age >= 20 ? "�꽦�씤" : "誘몄꽦�뀈�옄";
		String msg = String.format("%s�쓽 �굹�씠�뒗 %d�궡�씠怨�, %s�엯�땲�떎", name, age, adult);
		request.setAttribute("msg", msg);
		return "ex01-result";
		
	}
}
