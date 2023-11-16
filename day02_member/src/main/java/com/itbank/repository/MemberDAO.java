package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.model.MemberDTO;

public interface MemberDAO {

	@Select("select * from member5 order by idx")
	List<MemberDTO> selectList();
	
	@Insert("insert into member5 (userid, userpw, username, birth, gender) values(#{userid}, #{userpw}, #{username}, #{birth}, #{gender})")
	int insert(MemberDTO dto);
	
	@Update("update member5 set userpw=#{userpw}, username=#{username}, birth=#{birth}, gender=#{gender} where idx=#{idx}")
	int update(MemberDTO dto);
	
	@Delete("delete member5 where idx=#{idx}")
	int delete(int idx);
	
	@Select("select * from member5 where idx=#{idx}")
	MemberDTO selectOne(int idx);
	
}
