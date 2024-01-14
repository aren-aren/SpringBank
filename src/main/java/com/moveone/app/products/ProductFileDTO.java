package com.moveone.app.products;

import com.moveone.app.files.FileDTO;

public class ProductFileDTO extends FileDTO {
    private Long productNum;

    public Long getProductNum() {
        return productNum;
    }

    public void setProductNum(Long productNum) {
        this.productNum = productNum;
    }
}
