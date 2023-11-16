package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.HomeplusDTO;
import com.itbank.repository.HomeplusDAO;

@Service
public class HomeplusService {
	
	@Autowired
	private HomeplusDAO dao;
	
	private java.util.Date now = new java.util.Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private final String saveDirectory = "D:\\upload_homeplus";
	
	public HomeplusService() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	private void upload(MultipartFile file, String fileName) {
		File dest = new File(saveDirectory, fileName);
		
		try {
			file.transferTo(dest);
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void remove(String fileName) {
		File dest = new File(saveDirectory, fileName);
		
		if(dest.exists()) {
			dest.delete();
		}
	}

	public List<HomeplusDTO> getList() {
		return dao.selectList();
	}

	public int add(HomeplusDTO dto) {		
		String thumbnailName =
				sdf.format(now) + "_" + dto.getProductName() + "_thumbnail." +  dto.getThumbnail().getContentType().split("/")[1];
		String reviewImageName =
				sdf.format(now) + "_" + dto.getProductName() + "_review." +  dto.getReviewImage().getContentType().split("/")[1];
		upload(dto.getThumbnail(), thumbnailName);
		upload(dto.getReviewImage(), reviewImageName);
		dto.setThumbnailName(thumbnailName);
		dto.setReviewImageName(reviewImageName);
		return dao.insert(dto);
	}

	public HomeplusDTO getDTO(int idx) {
		return dao.selectOne(idx);
	}

	public List<HomeplusDTO> getListByCondition(HashMap<String, String> param) {		
		return dao.selectByCondition(param);
	}

	public int modify(HomeplusDTO dto) {		
		if(dto.getThumbnail() != null) {
			remove(dto.getThumbnailName());
			String thumbnailName =
					sdf.format(now) + "_" + dto.getProductName() + "_thumbnail." +  dto.getThumbnail().getContentType().split("/")[1];
			upload(dto.getThumbnail(), thumbnailName);
			dto.setThumbnailName(thumbnailName);
		}
		if(dto.getReviewImage() != null) {
			remove(dto.getReviewImageName());
			String reviewImageName =
					sdf.format(now) + "_" + dto.getProductName() + "_review." +  dto.getReviewImage().getContentType().split("/")[1];
			upload(dto.getReviewImage(), reviewImageName);
			dto.setReviewImageName(reviewImageName);
		}
		
		return dao.update(dto);
	}
	
	public int remove(int idx) {
		return dao.delete(idx);
	}
}
