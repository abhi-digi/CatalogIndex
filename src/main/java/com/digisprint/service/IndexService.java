package com.digisprint.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.digisprint.model.Product;

public interface IndexService {
	public void indexProductData(String siteName);

	public  List<Product>  getLast1HourUpdatedData();
}
