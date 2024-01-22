package com.moveone.app.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@ModelAttribute("title")
	public String getTitle() {
		return "Member";
	}
	
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	@PostMapping("join")
	public String join(MemberDTO memberDTO, MultipartFile file, Model model) throws Exception{
		
		int result = memberService.join(memberDTO, file);
		
		String msg = (result == 0)? "가입실패" : "가입성공";
		
		model.addAttribute("msg", msg);
		model.addAttribute("path", "/");
		
		return "commons/result";
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(MemberDTO memberDTO, HttpSession session, Model model) {
		memberDTO = memberService.getLogin(memberDTO);
		session.setAttribute("member", memberDTO);
		
		if(memberDTO == null) {
			model.addAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
			return "member/login";
		}
		
		return "redirect:/";
	}
	
	@GetMapping("logout")
	public String getLogout(HttpSession session) throws Exception {
//		session.setAttribute("member", null);
//		session.removeAttribute("member");
//		session.removeValue("member");
		session.invalidate();
		
		return "redirect:/";
	}
	
	// map to member/mypage.jsp
	@GetMapping("mypage")
	public void getDetail() throws Exception { }
	
	// map to member/update.jsp
	@GetMapping("update")
	public void setUpdate() throws Exception { }
	
	@PostMapping("update")
	public String setUpdate(MemberDTO memberDTO, HttpSession httpSession) throws Exception {
		MemberDTO loginDTO = (MemberDTO) httpSession.getAttribute("member");
		memberDTO.setUserName(loginDTO.getUserName());
		memberDTO = memberService.setUpdate(memberDTO);
		
		if(memberDTO != null) {
			httpSession.setAttribute("member", memberDTO);
		}
		
		return "redirect:./mypage";
	}
}
