package com.moveone.app.products;

import com.moveone.app.utils.Pager;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAO {

    @Autowired
    SqlSession sqlSession;

    private final String namespace = "com.moveone.app.products.ProductDAO.";

    public List<ProductDTO> getList(Pager pager) {
        return sqlSession.selectList(namespace + "getList", pager);
    }

    public Long getTotal() {
        return sqlSession.selectOne(namespace + "getTotal");
    }
}
