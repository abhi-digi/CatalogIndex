package com.digisprint.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digisprint.bean.Product_Index;
import com.digisprint.converter.ProductConverter;
import com.digisprint.data.service.ProductDataService;
import com.digisprint.elastic.repository.ProductElasticRepository;
import com.digisprint.model.Product;
import com.digisprint.service.IndexService;

@Service
public class IndexServiceImpl implements IndexService{

	@Autowired(required = true)
	private ProductElasticRepository prodElasticRepo;
	
	@Autowired
	private ProductDataService prodDataService;

	@Override
	public void indexProductData(String siteName) {
		
		List<String> siteIds = new ArrayList<String>();
		siteIds.add(siteName);
		ProductConverter pc = null;
		List<Product_Index> pi = new ArrayList<>();
		
		List<Product> allProductsToIndex = prodDataService.getAllProductsBySites(siteIds);
		for (Product product : allProductsToIndex) {
			 pc = new ProductConverter();
			 pi.add(pc.getProduct_Index(product));
		}
		
		prodElasticRepo.saveAll(pi);
	}

}
