package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BookDTO;
import com.itbank.repository.BookDAO;

@Service
public class BookService {
	
	@Autowired
	private BookDAO dao;

	public List<BookDTO> getList() {
		return dao.selectList();
	}

	public List<BookDTO> getListByName(String search) {
		return dao.selectListByName(search);
	}

	public int add(BookDTO dto) {
		return dao.insert(dto);
	}

	public BookDTO detail(int idx) {
		return dao.detail(idx);
	}

	public int modify(BookDTO dto) {
		return dao.update(dto);
	}

	public int delete(int idx) {
		return dao.delete(idx);
	}

}
