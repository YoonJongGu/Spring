package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.Ex04DTO;
import com.itbank.repository.Ex04DAO;

@Service
public class Ex04Service {
	
	@Autowired
	private Ex04DAO dao;
	
	private final String saveDirectory = "D:\\upload_2023";
	
	public Ex04Service() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	public int upload(MultipartFile uploadFile) {
		File dest = new File(saveDirectory, uploadFile.getOriginalFilename());
		
		try {
			uploadFile.transferTo(dest);
			System.out.println(dest.getAbsolutePath());
			System.out.println("===============================");
			return 1;
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}	

		return 0;
	}

	public int uploadMultipleFile(Ex04DTO dto) {
		int row = 0;
		
		// 문자열을 특정 글자로 구분하여 저장하기
		String fileName = "";
		
		for(MultipartFile f : dto.getUploadFile()) {
			row += upload(f);
			fileName += f.getOriginalFilename();
			fileName += ",";
		}
		
		System.out.println(row);
		fileName = fileName.substring(0, fileName.lastIndexOf(","));
		dto.setFileName(fileName);
		System.out.println(fileName);
		
		int insert = dao.insert(dto);
		
		return insert;
	}

	public List<Ex04DTO> getList() {
		return dao.selectAll();
	}

}
