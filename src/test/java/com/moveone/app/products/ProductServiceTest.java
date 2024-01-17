package com.moveone.app.products;

import com.moveone.app.MyTest;
import com.moveone.app.utils.Pager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

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

    //@Test
    public void add() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName("Rqqqq");
        productDTO.setProductContents("fnweunfjkew");
        productDTO.setProductRate(2.3);

        MultipartFile[] files = new MultipartFile[0];
        int reuslt = productService.add(productDTO, files);

        assertEquals(1, reuslt);
    }

    //@Test
    public  void detail(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductNum(3L);
        ProductDTO result = productService.getDetail(productDTO);

        System.out.println(result);
    }
}