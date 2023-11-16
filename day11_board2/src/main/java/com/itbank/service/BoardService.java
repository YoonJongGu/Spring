package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.BoardDTO;
import com.itbank.model.PagingDTO;
import com.itbank.model.ReplyDTO;
import com.itbank.repository.BoardDAO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	private final String saveDirectory = "D:\\board2_upload";
	
	public BoardService() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	private void upload(MultipartFile uploadFile) {
		File dest = new File(saveDirectory, uploadFile.getOriginalFilename());
		
		try {
			uploadFile.transferTo(dest);
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardDTO> getList(PagingDTO paging) {
		return dao.selectList(paging);
	}

	public int write(BoardDTO board) {
		String fileName = "";
		
		for(MultipartFile file : board.getUploadFile()) {
			upload(file);
			fileName += file.getOriginalFilename();
			fileName += ",";
		}
		if(fileName.equals("") == false) {
			fileName = fileName.substring(0, fileName.length() - 1);
		}		
		board.setUploadFileName(fileName);
		return dao.insert(board);
	}

	public BoardDTO getDTO(int idx) {
		return dao.selectOne(idx);
	}

	public int plusCount(int idx) {
		return dao.plusCount(idx);
	}

	public int modify(BoardDTO board) {
		String fileName = "";
		
		for(MultipartFile file : board.getUploadFile()) {
			upload(file);
			fileName += file.getOriginalFilename();
			fileName += ",";
		}		
		if(fileName.equals("") == false) {
			fileName = fileName.substring(0, fileName.length() - 1);
		}		
		board.setUploadFileName(fileName);
		return dao.update(board);
	}

	public int remove(int idx) {
		return dao.delete(idx);
	}

	public int getCount() {
		return dao.selectCount();
	}

	public int getCountByKeyword(String keyword) {
		return dao.selectCountByKeyword(keyword);
	}

	public List<BoardDTO> getListByKeyword(HashMap<String, Object> map) {
		return dao.selectListByKeyword(map);
	}

	public List<ReplyDTO> getReply(int idx) {
		return dao.selectReply(idx);
	}

	public int add_reply(ReplyDTO reply) {
		return dao.insert_reply(reply);
	}

}
