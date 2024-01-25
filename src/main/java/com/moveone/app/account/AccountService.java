package com.moveone.app.account;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moveone.app.member.MemberDTO;
import com.moveone.app.utils.Pager;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	public int addAccount(AccountDTO account) {
		Long accountNum = Calendar.getInstance().getTimeInMillis();
		account.setAccountNum(accountNum);
		
		System.out.println(account);
		
		String pattern = "[0-9]{4}";
		
		if(!account.getAccountPw().matches(pattern)) {
			return -1;
		}
		
	 	return accountDAO.addAccount(account);
	}

	public List<AccountDTO> accountList(MemberDTO loginDTO, Pager pager) {
		pager.makeRow();
		
		Long totalCount = accountDAO.getTotalCount(loginDTO);
		pager.makeBlock(totalCount);
		
		Map<String, Object> map = new HashMap<>();
		map.put("dto", loginDTO);
		map.put("pager", pager);
		
		return accountDAO.accountList(map);
	}

}
