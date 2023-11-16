package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.HomeplusDTO;

@Repository
public interface HomeplusDAO {

	List<HomeplusDTO> selectList();

	int insert(HomeplusDTO dto);

	HomeplusDTO selectOne(int idx);

	List<HomeplusDTO> selectByCondition(HashMap<String, String> param);

	int delete(int idx);

	int update(HomeplusDTO dto);

}
