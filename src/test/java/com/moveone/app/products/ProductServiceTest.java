package com.moveone.app.products;

import com.moveone.app.MyTest;
import com.moveone.app.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceTest extends MyTest {

    @Autowired
    ProductService productService;

    @Test
    public void getList()  {
        Pager pager = new Pager();
        pager.setPage(1L);
        List<ProductDTO> list = productService.getList(pager);

        System.out.println(pager);

        assertEquals(10, list.size());
    }
}