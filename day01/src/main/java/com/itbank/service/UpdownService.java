package com.itbank.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service	// 요청/응답, DB에 상관없는 비즈니스 로직을 구현하는 부분
public class UpdownService {
	
	private int answer;
	private int count;
	
	public void initialize() {
		Random ran = new Random();
		answer = ran.nextInt(100) + 1;
		count = 0;
	}

	public String getStatus(int user) {
		count++;
		String status = null;
		
		if(answer == user) status = "Correct";
		else if(answer > user) 	status = "Up";
		else 					status = "Down";
		
		return status;
	}
	
	public int getCount() {
		return count;
	}
}
