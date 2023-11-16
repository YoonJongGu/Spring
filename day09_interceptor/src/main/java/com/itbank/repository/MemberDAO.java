package com.itbank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.MemberDTO;
import com.itbank.model.PagingDTO;

@Repository
public interface MemberDAO {

	List<MemberDTO> selectList();

	int insert(MemberDTO dto);

	MemberDTO login(MemberDTO user);
	
	int cntMember();

	List<MemberDTO> selectMember(PagingDTO dto);

}
