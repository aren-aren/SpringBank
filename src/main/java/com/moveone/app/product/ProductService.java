package com.moveone.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moveone.app.util.Pager;

@Service
public class ProductService {
	@Autowired
	ProductDAO productDAO;
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
		pager.makeRows();
		Long totalCount = productDAO.getTotal(pager);
		pager.makeNum(totalCount);
		
		
		return productDAO.getList(pager);
	}
	
	public ProductDTO getDetail(ProductDTO dto) throws Exception {
		return productDAO.getDetail(dto);
	}
}
