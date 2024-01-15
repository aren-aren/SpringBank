package com.moveone.app.board.qna;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moveone.app.MyTest;
import com.moveone.app.board.BoardDTO;
import com.moveone.app.utils.Pager;

public class QnATest extends MyTest {

	@Autowired
	QnADAO dao;
	
	@Test
	public void getListTest() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		
		List<BoardDTO> list = dao.getList(pager);
		
		assertNotEquals(0, list.size());
	}
}
