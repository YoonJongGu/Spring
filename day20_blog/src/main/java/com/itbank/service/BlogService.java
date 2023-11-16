package com.itbank.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.component.UploadComponent;
import com.itbank.model.BlogDTO;
import com.itbank.repository.BlogDAO;

@Service
public class BlogService {

	@Autowired private BlogDAO dao;
	@Autowired private UploadComponent uploadComponent;
	
	public int insert(BlogDTO dto) throws IllegalStateException, IOException {
		int row = 0;
		int idx;
		int size = dto.getUploadFiles().size();
		
		// 업로드
		List<MultipartFile> uploadFiles = dto.getUploadFiles();
	    List<String> oldNames = Arrays.asList(uploadFiles.stream().map(e -> e.getOriginalFilename()).toArray(String[]::new));
	    List<String> newNames = dto.getNewNameList();
	    
		for(MultipartFile f : uploadFiles) {
			dto.getNewNameList().add(uploadComponent.upload(f));
		}
		
		// DB추가
		row = dao.insertBlog(dto);
		idx = dao.selectLastIdx();
		dto.setIdx(idx);
		for(int i = 0; i < size; i++) {
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("blog_idx", String.valueOf(idx));
			param.put("oldName", oldNames.get(i));
			param.put("newName", newNames.get(i));
			dao.insertUploadImage(param);
		}
		
		return row;
	}

	public List<HashMap<String, String>> getBlog(int offset) {
		return dao.getBlog(offset);
	}

	public List<String> getImages(int idx) {
		return dao.getImages(idx);
	}

	
	
}
