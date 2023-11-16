package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import com.itbank.model.BlogDTO;

public interface BlogDAO {

	int insertBlog(BlogDTO dto);

	int selectLastIdx();

	int insertUploadImage(HashMap<String, String> param);

	List<HashMap<String, String>> getBlog(int offset);

	List<String> getImages(int idx);

}
