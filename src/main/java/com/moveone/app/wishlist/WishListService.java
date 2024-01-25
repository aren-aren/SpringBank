package com.moveone.app.wishlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moveone.app.account.AccountDTO;
import com.moveone.app.member.MemberDTO;
import com.moveone.app.products.ProductDTO;
import com.moveone.app.utils.Pager;

@Service
public class WishListService {
	@Autowired
	private WishListDAO wishListDAO;

	public int add(AccountDTO accountDTO) {
		return wishListDAO.addWishList(accountDTO);
	}

	public List<ProductDTO> getList(MemberDTO memberDTO, Pager pager) {
		pager.makeRow();
		Long totalCount = wishListDAO.getTotalCount(memberDTO);
		pager.makeBlock(totalCount);
		
		Map<String, Object> map = new HashMap<>();
		map.put("dto", memberDTO);
		map.put("pager", pager);
		
		return wishListDAO.getList(map);
	}

}
