package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Service
public class BoardService {
	
	@Autowired private BoardDAO dao;

	public List<BoardDTO> getBoardList(int offset) {
		return dao.selectBoardList(offset);
	}

}
