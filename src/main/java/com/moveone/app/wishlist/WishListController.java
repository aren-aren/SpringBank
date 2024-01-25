package com.moveone.app.wishlist;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moveone.app.member.MemberDTO;

@Controller
@RequestMapping("/wishlist/*")
public class WishListController {
	
	@Autowired
	private WishListService wishListService;
	
	@GetMapping("add")
	public String addWishList(WishListDTO wishListDTO, HttpSession session, Model model) {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		wishListDTO.setUserName(memberDTO.getUserName());
		System.out.println(wishListDTO);
		
		int result = wishListService.add(wishListDTO);
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
}
