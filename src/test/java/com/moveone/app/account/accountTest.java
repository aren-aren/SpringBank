package com.moveone.app.account;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moveone.app.MyTest;
import com.moveone.app.member.MemberDTO;

public class accountTest extends MyTest {
	@Autowired
	private AccountDAO accountDAO;
	
	@Test
	public void getListTest() {
		
	}
}
