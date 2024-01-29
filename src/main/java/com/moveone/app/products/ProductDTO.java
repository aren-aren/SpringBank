package com.moveone.app.products;

import java.util.List;

public class ProductDTO {
    private Long productNum;
    private String productName;
    private String productContents;
    private Double productRate;
    private Double productJumsu;
    private Long productCount;
    private Long productSale;
    private List<ProductFileDTO> productFiles;
    private List<ReplyDTO> replies;

    public List<ProductFileDTO> getProductFiles() {
        return productFiles;
    }

    public void setProductFiles(List<ProductFileDTO> productFiles) {
        this.productFiles = productFiles;
    }

    public Long getProductNum() {
        return productNum;
    }

    public void setProductNum(Long productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductContents() {
        return productContents;
    }

    public void setProductContents(String productContents) {
        this.productContents = productContents;
    }

    public Double getProductRate() {
        return productRate;
    }

    public void setProductRate(Double productRate) {
        this.productRate = productRate;
    }

    public Double getProductJumsu() {
        return productJumsu;
    }

    public void setProductJumsu(Double productJumsu) {
        this.productJumsu = productJumsu;
    }

    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }

    public Long getProductSale() {
        return productSale;
    }

    public void setProductSale(Long productSale) {
        this.productSale = productSale;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productNum=" + productNum +
                ", productName='" + productName + '\'' +
                ", productContents='" + productContents + '\'' +
                ", productRate=" + productRate +
                ", productJumsu=" + productJumsu +
                ", productCount=" + productCount +
                ", productSale=" + productSale +
                '}';
    }

	public List<ReplyDTO> getReplies() {
		return replies;
	}

	public void setReplies(List<ReplyDTO> replies) {
		this.replies = replies;
	}

}
