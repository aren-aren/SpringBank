package com.moveone.app.util;

public class Pager {
	private Long startRow;
	private Long lastRow;
	private Long perPage=10l;
	private Long page;
	
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
		return page;
	}
	public void setPage(Long page) {
		if(page == null || page < 1) {
			this.page = 1l;
		} else {
			this.page = page;
		}
		makeRows();
	}
	
	public void makeRows() {
		this.startRow = 1 + (getPage()-1)*getPerPage();
		this.lastRow = getPage()*getPerPage();
	}
}
