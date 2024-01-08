package com.moveone.app.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moveone.app.MyTest;
import com.moveone.app.util.Pager;

public class ProductDAOTest extends MyTest {

	@Autowired
	ProductDAO dao;
	
	@Test
	public void getListTest() throws Exception {
		
		Pager page = new Pager();
		page.setPage(1l);
		List<ProductDTO> list = dao.getList(page);
		
		assertEquals(10, list.size());
	}
	
	
	
	//@Test
	public void getDetailTest() throws Exception {
		ProductDTO dto = new ProductDTO();
		dto.setProductNum(1l);
		
		dto = dao.getDetail(dto);
		
		assertNotNull(dto);
	}
	
	//@Test
	public void getAddTest() throws Exception {
		ProductDTO dto = new ProductDTO();
		
		for(int i = 0 ; i < 50 ; ++i) {
			dto.setProductName("test" + i);
			dto.setProductContents("testContents" + i);
			dto.setProductRate(3.4);
			dto.setProductJumsu(3.1);
			
			int result = dao.addProduct(dto);
			
			if(i%10 == 0) {
				Thread.sleep(500);
			}
		}
		
		System.out.println("완료");
	}

}
