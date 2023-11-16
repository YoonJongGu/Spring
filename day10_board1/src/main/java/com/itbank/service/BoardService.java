package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BoardDTO;
import com.itbank.model.PagingDTO;
import com.itbank.repository.BoardDAO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;

	public List<BoardDTO> getList(PagingDTO paging) {
		return dao.selectList(paging);
	}

	public int write(BoardDTO board) {
		return dao.insert(board);
	}

	public List<BoardDTO> getListByTitle(HashMap<String, Object> map) {
		return dao.selectListByTitle(map);
	}

	public BoardDTO getDTO(int idx) {
		return dao.selectOne(idx);
	}

	public int modify(BoardDTO board) {
		return dao.update(board);
	}

	public int remove(int idx) {
		return dao.delete(idx);
	}

	public int cntBoard() {
		return dao.cntBoard();
	}

	public int cntBoardByTitle(String keyword) {
		return dao.cntBoardByTitle(keyword);
	}

}
