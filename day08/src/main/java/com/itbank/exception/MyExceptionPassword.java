package com.itbank.exception;

public class MyExceptionPassword extends Exception {

	private static final long serialVersionUID = 1196311017350771093L;
	
	@Override
	public String getMessage() {
		return "비밀번호 형식이 올바르지 않습니다";
	}
	
	
}
