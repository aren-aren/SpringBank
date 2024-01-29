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

import com.moveone.app.member.MemberDTO;
import com.moveone.app.utils.Pager;
import com.moveone.app.utils.TagChanger;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@PostMapping("add")
	public String setReply(ReplyDTO replyDTO, HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		replyDTO.setUserName(memberDTO.getUserName());
		
		replyDTO.setReplyContents(TagChanger.tagChange(replyDTO.getReplyContents()));
		
		System.out.println(replyDTO);
		int result = replyService.setReply(replyDTO);
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	@GetMapping("list")
	@ResponseBody
	public List<ReplyDTO> getList(ProductDTO productDTO, Pager pager) {
		List<ReplyDTO> list = replyService.getList(productDTO, pager);
		
		//model.addAttribute("list", list);
		return list;
	}
}
