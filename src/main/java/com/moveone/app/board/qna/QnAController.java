package com.moveone.app.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.moveone.app.board.BoardDTO;
import com.moveone.app.member.MemberDTO;
import com.moveone.app.utils.Pager;

@Controller
@RequestMapping(value="/qna/*")
public class QnAController {
	
	@Autowired
	private QnAService qnaService;
	
	@ModelAttribute("title")
	public String getTitle() {
		return "Q&A";
	}
	
	@ModelAttribute("bbs")
	public Integer getKind() {
		return 1;
	}
	
	@ModelAttribute("path")
	public String getPath() {
		return "qna";
	}
	
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
		List<BoardDTO> list = qnaService.getList(pager);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@GetMapping("detail")
	public String getDetail(QnADTO qnaDTO, Model model) throws Exception {
		QnADTO dto = (QnADTO) qnaService.getDetail(qnaDTO);
		
		model.addAttribute("dto", dto);
		
		
		
		return "board/detail";
	}
	
	@GetMapping("add")
	public String add() throws Exception {
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(QnADTO qnaDTO, MultipartFile[] files, HttpSession session) throws Exception{
		System.out.println("qna, add = " + qnaDTO);
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		qnaDTO.setWriter(memberDTO.getUserName());
		qnaService.setAdd(qnaDTO, files);
		
		return "redirect:./list";
	}
	
	@GetMapping("reply")
	public String reply(BoardDTO boardDTO, Model model) {
		model.addAttribute("dto", boardDTO);
		
		return "board/reply";
	}
	
	@PostMapping("reply")
	public String reply(QnADTO qnaDTO, MultipartFile[] attachs, HttpSession session) throws Exception {
		System.out.println("qna, reply = " + qnaDTO);
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		qnaDTO.setWriter(memberDTO.getUserName());
		int result = qnaService.setReply(qnaDTO, attachs);
		
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public String update(QnADTO qnaDTO, Model model) throws Exception {
		QnADTO target = (QnADTO) qnaService.getDetail(qnaDTO);
		
		model.addAttribute("dto", target);
		
		return "board/update";
	}
	
	@PostMapping("update")
	public String update(QnADTO qnaDTO, MultipartFile[] attachs) throws Exception {
		System.out.println("qna, update = " + qnaDTO);
		int result = qnaService.setUpdate(qnaDTO, attachs);
		
		return "redirect:./detail?noticeNum=" + qnaDTO.getNoticeNum();
	}
	@PostMapping("delete")
	public String delete(QnADTO qnaDTO) throws Exception {
		int result = qnaService.setDelete(qnaDTO);
		
		return "redirect:./list";
	}
}
