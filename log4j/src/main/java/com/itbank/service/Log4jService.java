package com.itbank.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.repository.Log4jDAO;

@Service
public class Log4jService {
	
	@Autowired
	private Log4jDAO dao;
	
	public String getVersion() {
		return dao.selectVersion();
	}

	public Date getDate() {
		return dao.selectDate();
	}

	public List<HashMap<String, Object>> getList() {
		return dao.selectList();
	}

}
