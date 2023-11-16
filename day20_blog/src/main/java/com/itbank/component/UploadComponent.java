package com.itbank.component;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadComponent {

	public UploadComponent() {
		File dir = new File("D:\\upload");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	public String upload(MultipartFile f) throws IllegalStateException, IOException {
		
		String oldName = f.getOriginalFilename();
		String newName = UUID.randomUUID().toString().replaceAll("-", "");
		String ext = oldName.substring(oldName.lastIndexOf("."));
		
		newName += ext;
		
		File dest = new File("D:\\upload", newName);
		f.transferTo(dest);
		
		return newName;
	}
	
	
}
