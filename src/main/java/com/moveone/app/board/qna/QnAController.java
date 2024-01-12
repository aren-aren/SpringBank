package com.moveone.app.board.qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/qna/*")
public class QnAController {
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getList() throws Exception {
		return "qna/list";
	}
}
