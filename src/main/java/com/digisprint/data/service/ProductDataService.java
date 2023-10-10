package com.digisprint.data.service;

import java.util.List;

import com.digisprint.model.Product;

public interface ProductDataService {
	
	public List<Product> getAllProductsBySites(List<String> siteIds);
	public List<Product> getLatestUpdatedRecord(List<String> siteNames);
	public List<Product> getAllProducts();
}
