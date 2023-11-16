package com.itbank.repository;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface Log4jDAO {
	
	@Select("select banner from v$version")
	String selectVersion();
	
	@Select("select sysdate from dual")
	Date selectDate();
	
	@Select("select * from member5 order by idx")
	List<HashMap<String, Object>> selectList();
	
}
