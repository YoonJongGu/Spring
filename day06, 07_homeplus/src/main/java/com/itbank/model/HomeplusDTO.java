package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

//	IDX         NOT NULL NUMBER        
//	CATEGORY    NOT NULL VARCHAR2(20)  
//	PRODUCTNAME NOT NULL VARCHAR2(100) 
//	PRICE                NUMBER        
//	SCORE                NUMBER(2,1)   
//	THUMBNAIL            VARCHAR2(255) 
//	REVIEWIMAGE          VARCHAR2(255) 
//	REGISTDATE           DATE 

public class HomeplusDTO {
	
	private int idx;
	private String category;
	private String productName;
	private int price;
	private double score;
	private MultipartFile thumbnail;
	private MultipartFile reviewImage;
	private String thumbnailName;
	private String reviewImageName;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public MultipartFile getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(MultipartFile thumbnail) {
		this.thumbnail = thumbnail;
	}
	public MultipartFile getReviewImage() {
		return reviewImage;
	}
	public void setReviewImage(MultipartFile reviewImage) {
		this.reviewImage = reviewImage;
	}
	public String getThumbnailName() {
		return thumbnailName;
	}
	public void setThumbnailName(String thumbnailName) {
		this.thumbnailName = thumbnailName;
	}
	public String getReviewImageName() {
		return reviewImageName;
	}
	public void setReviewImageName(String reviewImageName) {
		this.reviewImageName = reviewImageName;
	}
	
}
