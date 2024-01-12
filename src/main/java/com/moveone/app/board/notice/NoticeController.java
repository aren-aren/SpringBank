package com.moveone.app.board.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getList() throws Exception {
		return "notice/list";
	}
}
