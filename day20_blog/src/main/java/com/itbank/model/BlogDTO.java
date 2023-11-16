package com.itbank.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BlogDTO {

	private int idx;
	private List<MultipartFile> uploadFiles;
	private List<String> newNameList = new ArrayList<String>();
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<MultipartFile> getUploadFiles() {
		return uploadFiles;
	}

	public void setUploadFiles(List<MultipartFile> uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	
	@Override
	public String toString() {
		
		String str = "text : " + text + "\n";
		str += "[\t\n";
		for(MultipartFile f : uploadFiles) {
			str += "\t" + f.getOriginalFilename() + "\n" ;
		}
		str += "]";
		return str;
	}

	public List<String> getNewNameList() {
		return newNameList;
	}

	public void setNewNameList(List<String> newNameList) {
		this.newNameList = newNameList;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
}
