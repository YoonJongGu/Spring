package com.itbank.model;

public class PagingDTO {
	
	private int nowPage;		// 요청 받은 페이지 번호(*)
	private int total;			// 총 게시글의 개수(*)
	private int perPage = 10;	// 페이지 당 출력할 글의 개수
	private int cntPage = 5;	// 페이지 번호를 출력할 개수
	
	private int offset;			// 요청 받은 페이지에 의해 건너뛸 레코드의 개수
//	private int section;		// 0(1~5), 1(6~10), 2(11~15) ...
	
	private int startPage;
	private int endPage;
	private int lastPage;		// ex) 게시글이 253개 이면 26페이지
//	private boolean prev;		// 이전 섹션이 존재하는가?
//	private boolean next;		// 다음 섹션이 존재하는가?
	
	public PagingDTO() {}
	
	public PagingDTO(int total, int nowPage) {
		setTotal(total);
		setNowPage(nowPage);
		calcLastPage(total);
		calcStartEndPage(nowPage);
		calcOffset(nowPage);		
	}
	
//	public PagingDTO(int total, int nowPage) {
//		offset = (nowPage - 1) * perPage;
//		// 첫번째 레코드에서 건너뛸 개수
//		
//		startPage = ((int)(nowPage - 0.1) / cntPage) * cntPage + 1;
//		//										0	   1	   2
//		// 페이지 구간을 섹션으로 구분할 때, 섹션의 시작점 (1~10),(11~20),(21~30)...
//		
//		endPage = startPage + cntPage - 1;
//		// 시작 페이지번호 + 9
//		
//		boolean flag = total % perPage != 0;
//		// 총 게시글 수가 페이지 당 출력 개수로 나누어 떨어지지 않는다(=나머지가 있다)
//		
//		lastPage = total / perPage + (flag ? 1 : 0);
//		// 전체 게시글 수를 페이지당 출력 개수로 나누고, 나머지가 있으면 1페이지를 더한다
//		
//		endPage = endPage >= lastPage ? lastPage : endPage;
//		// 마지막 페이지 번호와 마지막 섹션번호를 비교하여 작은 값을 선택한다
//		// (41~50 구간이지만 실제 46페이지만 있을 경우)
//	
//		section = (page - 1) / perSection;
//		// 0(1~10), 1(11~20), 2(21~30) ...
//		
//		int lastSection = (pageCount - 1) / perSection;
//		// [다음] 을 출력할지 말지 결정하기 위해 계산하는 지역변수 
//		
//		prev = begin > perSection;
//		// 현재 섹션의 시작번호가 섹션당 출력개수보다 크면 이전 섹션이 있다
//		// 현재 보고 있는 페이지가 13이고, begin은 11이면 perPage는 10이므로 이전 섹션이 존재함
//		
//		next = lastSection > section;
//		// 마지막 섹션이 현재 섹션보다 더 큰값이면 [다음]을 출력한다
//		// 내가 보는 페이지는 21, 마지막 값은 40이면 다음을 출력한다
//	}
	
//	// 확인용 toString()
//	@Override
//	public String toString() {
//		String str = "";
//		str += "요청 받은 페이지 : %d\n";
//		str += "전체 게시글 개수 : %d\n";
//		str += "전체 페이지 개수 : %d\n";
//		str += "현재 색션 번호 : %d\n";
//		str += "페이지 시작 번호 : %d\n";
//		str += "페이지 끝 번호 : %d\n";
//		str += "[이전] 출력 : %s\n";
//		str += "[다음] 출력 : %s\n";
//		str = String.format(str, nowPage, total, lastPage, section, startPage, endPage, prev, next);
//		return str;
//	}
	
	// 마지막 페이지 구하기
	private void calcLastPage(int total) {
		setLastPage(total / getPerPage() + (total % getPerPage() == 0 ? 0 : 1)); 
	}
	
	// 화면에 보여줄 처음페이지와 마지막 페이지 구하기
	private void calcStartEndPage(int nowPage) {
		setStartPage(1 + getCntPage() * ((nowPage - 1) / getCntPage()));		
		setEndPage(getStartPage() + getCntPage() - 1);
	}
	
	// 건너뛸 개수 구하기
	private void calcOffset(int nowPage) {
		setOffset((nowPage - 1) * getPerPage());
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
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getCntPage() {
		return cntPage;
	}
	public void setCntPage(int cntPage) {
		this.cntPage = cntPage;
	}	

}
