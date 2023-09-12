package com.digisprint.converter;

import org.springframework.stereotype.Component;

import com.digisprint.bean.Product_Index;
import com.digisprint.model.Product;

@Component
public class ProductConverter {
	
	public Product_Index getProduct_Index(Product product) {
		Product_Index pi = new Product_Index();
		
		pi.setId(product.getId());
		pi.setTitle(product.getTitle());
		pi.setProductDescription(product.getProductDescription());
		return pi;
	}

}
