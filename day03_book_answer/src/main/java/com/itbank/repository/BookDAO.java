package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.model.BookDTO;

@Repository
public interface BookDAO {

//	@Select("select * from book3 order by idx")
	@Select("select idx, name, price, publisher from book3 order by idx")
	List<BookDTO> selectListAll();

//	@Select("select * from book3 where ${type} like '%${keyword}%'")
	@Select("select idx, name, price, publisher from book3 "
			+ "where ${type} like '%${keyword}%'")
	List<BookDTO> selectSearchList(HashMap<String, String> param);

	@Insert("insert into book3 values ( book3_seq.nextval, "
			+ "#{name}, #{author}, #{publisher}, #{publishDate}, #{price}, #{memo}, #{score})")
	int insertBook(BookDTO dto);

	@Select("select * from book3 where idx=#{idx}")
	BookDTO selectOne(int idx);

	@Update("update book3 set "
			+ "name=#{name}, "
			+ "author=#{author}, "
			+ "publisher=#{publisher}, "
			+ "publishDate=#{publishDate}, "
			+ "price=#{price}, "
			+ "memo=#{memo}, "
			+ "score=#{score} "
			+ "	where idx=#{idx}")
	int update(BookDTO dto);

	@Delete("delete from book3 where idx=#{idx}")
	int delete(int idx);

	
}











