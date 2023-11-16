package com.itbank.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itbank.model.MemberDTO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		
		String url = request.getRequestURL().toString();
		url = URLEncoder.encode(url, "utf-8");
		
		if(login == null) {
			System.out.println("인터셉터 작동!!");
			response.sendRedirect(request.getContextPath() + "/member/login?url=" + url);
			return false;
		}

		return true;
	}
	
}
