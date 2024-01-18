package com.moveone.app.member;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moveone.app.MyTest;

public class MemberTest extends MyTest {
	@Autowired
	MemberDAO dao;
	
	//@Test
	public void join() {
		MemberDTO member = new MemberDTO();
		member.setUserName("1");
		member.setEmail("1");
		member.setName("1");
		member.setPassword("1");
		member.setPhone("1");
		member.setAddress("1");
		
		int result = dao.join(member);
		assertEquals(0, result);
	}
	
	//@Test
	public void login() {
		
		MemberDTO member = new MemberDTO();
		member.setUserName("moveone");
		member = dao.getDetail(member);
		
		System.out.println(member);
	}
}
