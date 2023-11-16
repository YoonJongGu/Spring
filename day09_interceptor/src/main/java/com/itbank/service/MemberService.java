package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.MemberDTO;
import com.itbank.model.PagingDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;

	public List<MemberDTO> getList() {
		return dao.selectList();
	}

	public int join(MemberDTO dto) {
		return dao.insert(dto);
	}

	public MemberDTO login(MemberDTO user) {
		return dao.login(user);
	}

	public int cntMember() {
		return dao.cntMember();
	}
	
	public List<MemberDTO> selectMember(PagingDTO dto) {
		return dao.selectMember(dto);
	}

}
