package com.itbank.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class TestDTO {

	private List<MultipartFile> uploadFiles;

	public List<MultipartFile> getUploadFiles() {
		return uploadFiles;
	}

	public void setUploadFiles(List<MultipartFile> uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	
	@Override
	public String toString() {
		String str = "[\t\n";
		for(MultipartFile f : uploadFiles) {
			str += "\t" + f.getOriginalFilename() + "\n" ;
		}
		str += "]";
		return str;
	}
}
