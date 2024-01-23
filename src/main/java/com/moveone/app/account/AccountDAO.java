package com.moveone.app.account;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moveone.app.member.MemberDTO;

@Repository
public class AccountDAO {
	@Autowired
	SqlSession sqlSession;
	private final String NAMESPACE = "com.moveone.app.account.AccountDAO.";
	
	public int addAccount(AccountDTO accountDTO) {
		return sqlSession.insert(NAMESPACE + "addAccount", accountDTO);
	}

	public List<AccountDTO> accountList(MemberDTO loginDTO) {
		return sqlSession.selectList(NAMESPACE + "accountList", loginDTO);
	}
}
