package com.itbank.service;

import java.util.HashMap;
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

	public List<MemberDTO> getList(PagingDTO paging) {
		return dao.selectList(paging);
	}

	public int join(MemberDTO dto) {
		return dao.insert(dto);
	}

	public MemberDTO login(HashMap<String, String> user) {
		return dao.login(user);
	}

	public MemberDTO getDTO(int idx) {
		return dao.selectOne(idx);
	}

	public int modify(MemberDTO user) {
		return dao.update(user);
	}

	public int remove(int idx) {
		return dao.delete(idx);
	}

	public int cntMember() {
		return dao.cntMember();
	}
	


}
