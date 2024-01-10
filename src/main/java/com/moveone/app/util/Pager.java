package com.moveone.app.util;

public class Pager {
	private Long startRow;
	private Long lastRow;
	private Long perPage=10L;
	private Long page;
	
	private Long totalPage;
	private Long startNum;
	private Long lastNum;
	
	private Boolean start;
	private Boolean last;
	
	private String search;
	private String kind;
	
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getPerPage() {
		return perPage;
	} 
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPage() {
		return (page == null || page < 1) ? 1L : page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Boolean getStart() {
		return start;
	}
	public void setStart(Boolean start) {
		this.start = start;
	}
	public Boolean getLast() {
		return last;
	}
	public void setLast(Boolean last) {
		this.last = last;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public void makeRows() {
		this.startRow = 1 + (getPage()-1)*getPerPage();
		this.lastRow = getPage()*getPerPage();
	}
	
	public void makeNum(Long totalCount) {
		//총 갯수로 총페이지 수 구하기
		totalPage = (long)Math.ceil((double)totalCount/getPerPage());
		
		//총 페이지 수로 총 블럭수 구하기
		Long perBlock = 5L;
		Long totalBlock = (long)Math.ceil((double)getTotalPage()/perBlock);
		
		//현재 페이지 번호로 현재 블럭 번호 구하기
		Long currentBlock = (long)Math.floor((double)(getPage()-1)/perBlock) + 1;
		
		//현재 블럭 번호로 시작번호와 끝 번호 구하기
		startNum = 1 + (currentBlock - 1)*perBlock;
		lastNum = currentBlock*perBlock;
		
		//이전, 다음 블럭 유무 구하기
		start = (currentBlock == 1);
		if(currentBlock == totalBlock) {
			last = true;
			lastNum = getTotalPage();
		}
	}
}
