package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.ReplyDTO;
import com.itbank.repository.ReplyDAO;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyDAO dao;

	public List<ReplyDTO> getReply(int idx) {
		return dao.selectReply(idx);
	}

	public int writeReply(ReplyDTO dto) {
		return dao.insertReply(dto);
	}

}
