package com.itbank.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.SessionStatus;

import com.itbank.exception.MyException;
import com.itbank.exception.MyExceptionPassword;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;

	public List<MemberDTO> getList() {
		return dao.selectList();
	}
	
	private String getHash(String userpw) {
		String hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(userpw.getBytes());
			hash = String.format("%0128x", new BigInteger(1, md.digest()));			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}		
		return hash;
	}
	
	private boolean successPass(String userpw) {
		boolean flag = false;
		String pattern = "^[0-9a-zA-Z]{8,}$";
		System.out.println(Pattern.matches(pattern, userpw));
		if(Pattern.matches(pattern, userpw)) {
			flag = true;
		}
				
		return flag;
	}

	public int add(MemberDTO dto) throws MyException, MyExceptionPassword {
		// 입력받은 나이가 0이면 예외가 발생함
		int age = Integer.parseInt(new SimpleDateFormat("yyyy").format(dto.getBirth()));
		age = 2023 - age;
		int tmp = 100 / age;
		System.out.println(tmp);
		if(dto.getUserid().length() < 8) {
			throw new MyException();
		}
		//======================
//		if(successPass(dto.getUserpw()) == false) {
//			throw new MyExceptionPassword();
//		}
		
		ArrayList<String> list = new ArrayList<String>();
		for(char i = 'a'; i <= 'z'; i ++) {
			list.add(i+"");
		}
		for(char i = 'A'; i <='Z'; i++) {
			list.add(i+"");
		}
		for(int i = 0; i<= 9; i++) {
			list.add(i+"");
		}
		System.out.println(list);
		System.out.println(dto.getUserpw());
		for(String x : list) {
			System.out.print(dto.getUserpw().length() < 8);
			System.out.print(!(dto.getUserpw().contains(x)));
			System.out.println();
//			if(dto.getUserpw().length() < 8 && !(dto.getUserpw().contains(x))) {
//				throw new MyExceptionPassword();
//				
//			}
	
		}
		// 입력받은 ID가 8글자 미만이면 강제로 예외 발생시키기
		dto.setUserpw(getHash(dto.getUserpw()));		
		return dao.insert(dto);
	}

	public MemberDTO login(HashMap<String, String> param) {
		String hash = getHash(param.get("userpw"));
		param.put("userpw", hash);
		return dao.login(param);
	}

	public void logout(SessionStatus status) {
		if(status.isComplete() == false) {
			status.setComplete();
		}
	}

}
