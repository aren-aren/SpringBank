package com.moveone.app.wishlist;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WishListDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.moveone.app.wishlist.WishListDAO.";
	
	public int addWishList(WishListDTO wishListDTO) {
		return sqlSession.insert(NAMESPACE + "addWishList", wishListDTO);
	}

}
