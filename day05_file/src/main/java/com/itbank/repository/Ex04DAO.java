package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.Ex04DTO;

@Repository
public interface Ex04DAO {
	
	@Insert("insert into uploadTest3 values(#{name}, #{age}, #{fileName})")
	int insert(Ex04DTO dto);
	
	@Select("select * from uploadTest3")
	List<Ex04DTO> selectAll();

}
