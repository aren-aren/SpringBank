package com.moveone.app.wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListService {
	@Autowired
	private WishListDAO wishListDAO;

	public int add(WishListDTO wishListDTO) {
		return wishListDAO.addWishList(wishListDTO);
	}

}
