package com.moveone.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moveone.app.board.BoardDTO;
import com.moveone.app.board.BoardService;
import com.moveone.app.utils.Pager;

@Controller
@RequestMapping(value="/qna/*")
public class QnAController {
	
	@Autowired
	@Qualifier("qnAService")
	private BoardService boardService;
	
	/*
	 * 답글
	 * 
	 * REF 	: 원본글과 답글 간의 그룹으로 구성
	 * 		  -> 원본글 - 자기자신의 NUM값이 REF값
	 * 		  -> 답글 - 부모글의 REF값
	 * STEP	: 그룹내에서 순서
	 * 		  -> 원본글 - 0
	 * 		  -> 답글 - 
	 * 				a. 같은 REF중 STEP이 부모의 STEP보다 큰 것들을 +1로 업데이트
	 * 				b. 부모글의 STEP에 +1한 값
	 * DEPTH : JSP출력시 들여쓰기 횟수
	 * 		  -> 부모의 DEPTH의 +1
	 */
	
	/*
	 * SELECT * FROM BOARD ORDER BY REF DESC, STEP ASC
	 * -> 최신글이 위로(REF DESC)
	 * -> 답글중 최신글이 위로(STEP ASC)
	 */
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getList(Pager pager, Model model) throws Exception {
		List<BoardDTO> list = boardService.getList(pager);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@GetMapping
	public String getDetail(QnADTO qnaDTO, Model model) throws Exception {
		QnADTO dto = (QnADTO) boardService.getDetail(qnaDTO);
		
		model.addAttribute("dto", dto);
		model.addAttribute("title", "Q&A");
		
		return "board/detail";
	}
}
