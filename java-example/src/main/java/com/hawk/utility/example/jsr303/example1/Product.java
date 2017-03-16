package com.hawk.utility.example.jsr303.example1;

import org.hibernate.validator.constraints.NotEmpty;

public class Product {
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	// 必须非空
    @NotEmpty
    private String productName;
    // 必须在 8000 至 10000 的范围内
    // @Price 是一个定制化的 constraint
    @Price private float price;
}
