package com.digisprint.service;

import java.util.List;

import com.digisprint.model.Product;

public interface IndexService {
	
	public List<Product> indexProductData(List<String> siteNames);
	public List<Product> indexPartailIndexData(List<String> siteNames);
}
