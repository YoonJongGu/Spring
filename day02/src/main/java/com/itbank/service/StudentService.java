package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.StudentDTO;
import com.itbank.repository.StudentDAO;

@Service
public class StudentService {
	
	@Autowired
	private StudentDAO dao;

	public List<StudentDTO> getList() {		
		return dao.selectList();
	}

	public int insert(StudentDTO dto) {
		return dao.insert(dto);
	}
	
	public int update(StudentDTO dto) {
		return dao.update(dto);
	}	

	public int delete(String name) {
		return dao.delete(name);
	}

	public StudentDTO getOne(String name) {
		return dao.selectOne(name);
	}
	
}
