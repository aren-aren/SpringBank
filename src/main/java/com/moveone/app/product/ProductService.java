package com.moveone.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	ProductDAO productDAO;
	
	public List<ProductDTO> getList() throws Exception {
		return productDAO.getList();
	}
	
	public ProductDTO getDetail(ProductDTO dto) throws Exception {
		return productDAO.getDetail(dto);
	}
}
