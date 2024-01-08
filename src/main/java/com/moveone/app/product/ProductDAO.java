package com.moveone.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.moveone.app.product.ProductDAO.";
	
	public List<ProductDTO> getList() throws Exception{
		return sqlSession.selectList(namespace + "getList");
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return sqlSession.selectOne(namespace + "getDetail", productDTO);
	}
	
	public Integer addProduct(ProductDTO productDTO) {
		return null;
	}
	
	public Integer modifyProduct(ProductDTO productDTO) {
		return null;
	}
	
	public Integer deleteProduct(ProductDTO productDTO) {
		return null;
	}
}
