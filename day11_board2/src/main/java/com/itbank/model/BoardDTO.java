package com.itbank.model;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//	IDX        NOT NULL NUMBER         
//	TITLE      NOT NULL VARCHAR2(100)  
//	WRITER     NOT NULL VARCHAR2(100)  
//	CONTENT    NOT NULL VARCHAR2(2000) 
//	WRITEDATE           DATE           
//	IPADDR     NOT NULL VARCHAR2(30)   
//	VIEWCOUNT           NUMBER         
//	UPLOADFILE          VARCHAR2(255)  

public class BoardDTO {
	
	private int idx;
	private String title;
	private String writer;
	private String content;
	private Date writeDate;
	private String ipaddr;
	private int viewCount;
	private String uploadFileName;
	private List<MultipartFile> uploadFile;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public List<MultipartFile> getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(List<MultipartFile> uploadFile) {
		this.uploadFile = uploadFile;
	}

}
