package com.itbank.exception;

public class MyException extends Exception {

	private static final long serialVersionUID = 2794062989492928771L;
	
	@Override
	public String getMessage() {		
		return "ID의 길이가 너무 짧습니다 (8글자 이상 입력해주세요)";
	}
	
}
