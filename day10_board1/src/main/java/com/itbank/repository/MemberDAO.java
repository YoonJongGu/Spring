package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.MemberDTO;
import com.itbank.model.PagingDTO;

@Repository
public interface MemberDAO {

	List<MemberDTO> selectList(PagingDTO paging);

	int insert(MemberDTO dto);

	MemberDTO login(HashMap<String, String> user);

	MemberDTO selectOne(int idx);

	int update(MemberDTO user);

	int delete(int idx);

	int cntMember();

}
