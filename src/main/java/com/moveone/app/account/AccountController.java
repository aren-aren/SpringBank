package com.moveone.app.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moveone.app.member.MemberDTO;
import com.moveone.app.products.ProductDTO;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping("add")
	public String addAccount(ProductDTO productDTO, Model model) {
		model.addAttribute("product", productDTO);
		return "account/add";
	}
	
	@PostMapping("add")
	public String addAccount(AccountDTO account, Model model, HttpSession session) {
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("member");
		account.setUserName(loginDTO.getUserName());
		int result = accountService.addAccount(account);
		
		model.addAttribute("path", "/products/list");
		model.addAttribute("msg", (result == 0)? "가입 실패" : "가입 성공");
		
		return "commons/result";
	}
	
	@GetMapping("list")
	public String accountList(HttpSession session, Model model) {
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("member");
		List<AccountDTO> accountList = accountService.accountList(loginDTO);
		
		model.addAttribute("list", accountList);
		 
		return "account/list";
	}
}
