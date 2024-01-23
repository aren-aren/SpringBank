package com.moveone.app.account;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moveone.app.member.MemberDTO;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	public int addAccount(AccountDTO account) {
		Long accountNum = Calendar.getInstance().getTimeInMillis();
		account.setAccountNum(accountNum);
		
		System.out.println(account);
		
	 	return accountDAO.addAccount(account);
	}

	public List<AccountDTO> accountList(MemberDTO loginDTO) {
		return accountDAO.accountList(loginDTO);
	}

}
