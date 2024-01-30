package com.moveone.app.products;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moveone.app.member.MemberDTO;
import com.moveone.app.utils.Pager;
import com.moveone.app.utils.TagChanger;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@PostMapping("add")
	public int setReply(ReplyDTO replyDTO, HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		replyDTO.setUserName(memberDTO.getUserName());
		
		replyDTO.setReplyContents(TagChanger.tagChange(replyDTO.getReplyContents()));
		
		System.out.println(replyDTO);
		int result = replyService.setReply(replyDTO);
		
		return result;
	}
	
	@GetMapping("list")
	@ResponseBody
	public List<ReplyDTO> getList(ProductDTO productDTO, Pager pager) {
		List<ReplyDTO> list = replyService.getList(productDTO, pager);
		
		//model.addAttribute("list", list);
		return list;
	}
	
	@PostMapping("update")
	@ResponseBody
	public int setUpdate(ReplyDTO replyDTO, HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		replyDTO.setUserName(memberDTO.getUserName());
		int result = replyService.setUpdate(replyDTO);
		
		System.out.println("updated : " + ((result == 0)? "fail" : "success"));
		System.out.println(replyDTO);
		
		return result;
	}
}
