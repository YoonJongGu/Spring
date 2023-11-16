package com.itbank.model;

public class PagingDTO {
	private int nowPage;
	private int startPage;
	private int endPage;
	private int total;
	private int lastPage;
	private int start;
	private int end;
	private int cntPerPage = 10;
	private int cntPage = 5;
	
	public PagingDTO() {}
	
	public PagingDTO(int total, int nowPage) {
		setNowPage(nowPage);
		setTotal(total);
		calcLastPage(getTotal());
		calcStartEndPage(getNowPage());
		calcStartEnd(getNowPage());
	}
	
	// 제일 마지막 페이지 계산
	public void calcLastPage(int total) {
		setLastPage((int)Math.ceil((double)total / (double)getCntPerPage()));
	}
	
	// 시작, 끝 페이지 계산
	public void calcStartEndPage(int nowPage) {
		setEndPage((int)Math.ceil((double)nowPage / (double)getCntPage()) * getCntPage());
		if(getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPage + 1);
		if(getStartPage() < 1) {
			setStartPage(1);
		}
	}
	
	// DB 쿼리에서 사용할 start, end 값 계산
	public void calcStartEnd(int nowPage) {
		setEnd(nowPage * getCntPerPage());
		setStart(getEnd() - getCntPerPage() + 1);
	}
	
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	public int getCntPage() {
		return cntPage;
	}

	public void setCntPage(int cntPage) {
		this.cntPage = cntPage;
	}	
}
