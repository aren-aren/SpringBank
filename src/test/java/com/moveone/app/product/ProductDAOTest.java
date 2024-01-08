package com.moveone.app.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moveone.app.MyTest;

public class ProductDAOTest extends MyTest {

	@Autowired
	ProductDAO dao;
	
	@Test
	public void getListTest() throws Exception {
		List<ProductDTO> list = dao.getList();
		
		assertNotEquals(0, list.size());
	}
	
	@Test
	public void getDetailTest() throws Exception {
		ProductDTO dto = new ProductDTO();
		dto.setProductNum(1l);
		
		dto = dao.getDetail(dto);
		
		assertNotNull(dto);
	}

}
