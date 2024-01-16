package com.moveone.app.board.qna;

import java.sql.Date;

import com.moveone.app.board.BoardDTO;

public class QnADTO extends BoardDTO {
	private Long noticeRef;
	private Long noticeStep;
	private Long noticeDepth;
	private Integer flag;
	

	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Long getNoticeRef() {
		return noticeRef;
	}
	public void setNoticeRef(Long noticeRef) {
		this.noticeRef = noticeRef;
	}
	public Long getNoticeStep() {
		return noticeStep;
	}
	public void setNoticeStep(Long noticeStep) {
		this.noticeStep = noticeStep;
	}
	public Long getNoticeDepth() {
		return noticeDepth;
	}
	public void setNoticeDepth(Long noticeDepth) {
		this.noticeDepth = noticeDepth;
	}
}
