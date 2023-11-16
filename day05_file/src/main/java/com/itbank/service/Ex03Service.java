package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.Ex03DTO;
import com.itbank.repository.Ex03DAO;

@Service
public class Ex03Service {
	
	@Autowired
	private Ex03DAO dao;
	
	private final String saveDirectory = "D:\\upload_2023";
	
	public Ex03Service() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}

	public int uploadDTO(Ex03DTO dto) {
		File dest = new File(saveDirectory, dto.getUploadFile().getOriginalFilename());
		
		try {
			dto.getUploadFile().transferTo(dest);
			System.out.println(dest.getAbsolutePath());
			// 사용자가 입력한 내용은 [이름], [나이], [파일]
			// DB에 저장할 내용은 [이름], [나이], [파일이름]
			dto.setFileName(dto.getUploadFile().getOriginalFilename());
			int row = dao.insert(dto);
			return row;
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	
		return 0;
	}

	public List<Ex03DTO> getList() {
		return dao.selectAll();
	}

}
