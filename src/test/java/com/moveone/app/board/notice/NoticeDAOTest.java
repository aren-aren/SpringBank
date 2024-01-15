package com.moveone.app.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moveone.app.MyTest;
import com.moveone.app.board.BoardDTO;
import com.moveone.app.utils.Pager;

public class NoticeDAOTest extends MyTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void getListTest() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		List<BoardDTO> list = noticeDAO.getList(pager);
		
		assertEquals(1, list.size());
	}
}
