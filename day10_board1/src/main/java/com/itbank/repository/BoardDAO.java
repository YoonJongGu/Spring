package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.BoardDTO;
import com.itbank.model.PagingDTO;

@Repository
public interface BoardDAO {

	List<BoardDTO> selectList(PagingDTO paging);

	int insert(BoardDTO board);

	List<BoardDTO> selectListByTitle(HashMap<String, Object> map);

	BoardDTO selectOne(int idx);

	int update(BoardDTO board);

	int delete(int idx);

	int cntBoard();

	int cntBoardByTitle(String keyword);

}
