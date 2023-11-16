package com.itbank.repository;

import java.util.List;

import com.itbank.model.ReplyDTO;

public interface ReplyDAO {

	List<ReplyDTO> selectReply(int idx);

	int insertReply(ReplyDTO dto);

}
