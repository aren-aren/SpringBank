package com.moveone.app.products;

import java.sql.Date;

public class ReplyDTO {
	private Long replyNum;
	private Long productNum;
	private String userName;
	private String replyContents;
	private Date replyDate;
	private Double replyJumsu;
	public Long getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(Long replyNum) {
		this.replyNum = replyNum;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getReplyContents() {
		return replyContents;
	}
	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public Double getReplyJumsu() {
		return replyJumsu;
	}
	public void setReplyJumsu(Double replyJumsu) {
		this.replyJumsu = replyJumsu;
	}
	
	@Override
	public String toString() {
		return "ReplyDTO [replyNum=" + replyNum + ", productNum=" + productNum + ", userName=" + userName + ", replyContents=" + replyContents + ", replyDate=" + replyDate + ", replyJumsu=" + replyJumsu + "]";
	}
}
