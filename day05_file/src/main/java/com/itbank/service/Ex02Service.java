package com.itbank.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class Ex02Service {
	
	private final String saveDirectory = "D:\\upload_2023";
	
	public Ex02Service() {
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

}
