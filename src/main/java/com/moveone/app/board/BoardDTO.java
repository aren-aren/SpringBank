package com.moveone.app.board;

import java.sql.Date;
import java.util.List;

public class BoardDTO {
	private Long noticeNum;
	private String noticeTitle;
	private String writer;
	private String noticeContents;
	private Date noticeDate;
	private Long noticeViews;
	private List<BoardFileDTO> boardFiles;
	
	public List<BoardFileDTO> getBoardFiles() {
		return boardFiles;
	}
	public void setBoardFiles(List<BoardFileDTO> boardFiles) {
		this.boardFiles = boardFiles;
	}
	public Long getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(Long noticeNum) {
		this.noticeNum = noticeNum;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public Long getNoticeViews() {
		return noticeViews;
	}
	public void setNoticeViews(Long noticeViews) {
		this.noticeViews = noticeViews;
	}
	
	@Override
	public String toString() {
		return this.noticeNum + " : " + this.noticeTitle + " : " + this.writer + " : " + this.noticeDate + " : " + this.noticeViews;
	}
}
