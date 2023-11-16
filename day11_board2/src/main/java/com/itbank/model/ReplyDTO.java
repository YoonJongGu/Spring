package com.itbank.model;

//	IDX          NOT NULL NUMBER         
//	REPLY_WRITER          VARCHAR2(100)  
//	REPLY_BOARD           NUMBER         
//	CONTENT      NOT NULL VARCHAR2(2000) 

public class ReplyDTO {
	
	private int idx;
	private String reply_writer;
	private int reply_board;
	private String content;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getReply_writer() {
		return reply_writer;
	}
	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
	}
	public int getReply_board() {
		return reply_board;
	}
	public void setReply_board(int reply_board) {
		this.reply_board = reply_board;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
	
}
