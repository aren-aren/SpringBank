package com.moveone.app.account;

import java.sql.Date;

import com.moveone.app.products.ProductDTO;

public class AccountDTO {
	private Long accountNum;
	private String userName;
	private Long productNum;
	private String accountPw;
	private Date accountDate;
	private Long accountBalance;
	private ProductDTO productDTO;
	
	public AccountDTO() {
	}
	
	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getAccountPw() {
		return accountPw;
	}
	public void setAccountPw(String accountPw) {
		this.accountPw = accountPw;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	public Long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	
	@Override
	public String toString() {
		return "AccountDTO [accountNum=" + accountNum + ", userName=" + userName + ", productNum=" + productNum + ", accountPw=" + accountPw + ", accountDate=" + accountDate + ", accountBalance=" + accountBalance + ", productDTO=" + productDTO + "]";
	}
}
