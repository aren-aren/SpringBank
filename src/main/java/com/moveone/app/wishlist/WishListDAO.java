package com.moveone.app.wishlist;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moveone.app.account.AccountDTO;
import com.moveone.app.member.MemberDTO;
import com.moveone.app.products.ProductDTO;

@Repository
public class WishListDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.moveone.app.wishlist.WishListDAO.";
	
	public int addWishList(AccountDTO accountDTO) {
		return sqlSession.insert(NAMESPACE + "addWishList", accountDTO);
	}

	public List<ProductDTO> getList(Map<String, Object> map) {
		return sqlSession.selectList(NAMESPACE + "getList", map);
	}

	public Long getTotalCount(MemberDTO memberDTO) {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", memberDTO);
	}

	public int deleteWish(Map<String, Object> map) {
		return sqlSession.delete(NAMESPACE + "deleteWish", map);
	}

}
