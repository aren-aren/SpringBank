package com.moveone.app.wishlist;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moveone.app.account.AccountDTO;
import com.moveone.app.member.MemberDTO;
import com.moveone.app.products.ProductDTO;
import com.moveone.app.utils.Pager;

@Controller
@RequestMapping("/wishlist/*")
public class WishListController {
	
	@Autowired
	private WishListService wishListService;
	
	@GetMapping("add")
	public String addWishList(AccountDTO accountDTO, HttpSession session, Model model) {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		accountDTO.setUserName(memberDTO.getUserName());
		System.out.println(accountDTO);
		
		int result = wishListService.add(accountDTO);
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	@GetMapping("list")
	public String getList(Pager pager, Model model, HttpSession session) {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		List<ProductDTO> list = wishListService.getList(memberDTO, pager);
		
		model.addAttribute("list", list);
		
		return "wishlist/list";
	}
}
