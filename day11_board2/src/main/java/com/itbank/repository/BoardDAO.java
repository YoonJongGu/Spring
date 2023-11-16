package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.BoardDTO;
import com.itbank.model.PagingDTO;
import com.itbank.model.ReplyDTO;

@Repository
public interface BoardDAO {

	List<BoardDTO> selectList(PagingDTO paging);

	int insert(BoardDTO board);

	BoardDTO selectOne(int idx);

	int plusCount(int idx);

	int update(BoardDTO board);

	int delete(int idx);

	int selectCount();

	int selectCountByKeyword(String keyword);

	List<BoardDTO> selectListByKeyword(HashMap<String, Object> map);

	List<ReplyDTO> selectReply(int idx);

	int insert_reply(ReplyDTO reply);

}
