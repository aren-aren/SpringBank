package com.moveone.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.moveone.app.board.BoardDTO;
import com.moveone.app.board.BoardService;
import com.moveone.app.utils.Pager;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	@Qualifier("noticeService")
	private BoardService boardService;
	
	@ModelAttribute("title")
	public String getTitle() {
		return "Notice";
	}
	
	@ModelAttribute("bbs")
	public Integer getKind() {
		return 0;
	}
	
	@ModelAttribute("path")
	public String getPath() {
		return "notice";
	}
	
	//@RequestMapping(value="list", method=RequestMethod.GET)
	@GetMapping("list")
	public String getList(Pager pager, Model model) throws Exception {
		List<BoardDTO> list = boardService.getList(pager);
		
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@GetMapping("detail")
	public String getdetail(NoticeDTO noticeDto, Model model) throws Exception {
		NoticeDTO dto = (NoticeDTO) boardService.getDetail(noticeDto);
		
		model.addAttribute("dto", dto);
		
		return "board/detail";
	}
	
	@GetMapping("add")
	public String add() throws Exception {
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(NoticeDTO noticeDTO, MultipartFile[] attachs) throws Exception {
		System.out.println(noticeDTO);
		int result = boardService.setAdd(noticeDTO, attachs);
		
		return "redirect:./list";
	}
	/*
	 * 요청의 종류
	 * 동기식 요청
	 * 비동기식 요청 (ajax)
	 * 
	 * 응답의 종류
	 * Forward
	 * 요청 -> 필요한 정보를 찾아줌
	 *  - 처음 요청한 url이 남음
	 * 
	 * Redirect
	 * 요청 -> 필요한 정보를 찾을 수 있는 곳을 알려줌
	 *  - url이 변경
	 */
	
	@GetMapping("update")
	public String update(NoticeDTO noticeDTO, Model model) throws Exception {
		NoticeDTO target = (NoticeDTO) boardService.getDetail(noticeDTO);
		model.addAttribute("dto", target);
		
		return "board/update";
	}
	
	@PostMapping("update")
	public String update(NoticeDTO noticeDTO, MultipartFile[] attachs) throws Exception {
		boardService.setUpdate(noticeDTO, attachs);
		
		return "redirect:./detail?noticeNum=" + noticeDTO.getNoticeNum();
	}
	
	@PostMapping("delete")
	public String delete(BoardDTO boardDTO) throws Exception {
		
		int result = boardService.setDelete(boardDTO);
		
		return "redirect:./list";
	}
	
}
