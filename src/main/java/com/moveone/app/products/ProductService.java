package com.moveone.app.products;

import com.moveone.app.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public List<ProductDTO> getList(Pager pager) {
        pager.makeRow();
        Long totalRow = productDAO.getTotal();

        pager.makeBlock(totalRow);

        return productDAO.getList(pager);
    }
}
