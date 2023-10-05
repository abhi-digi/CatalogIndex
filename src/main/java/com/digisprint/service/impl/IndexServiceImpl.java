package com.digisprint.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
		if(siteName == null || siteName.isEmpty()) {
			return;
		}
		siteIds.add(siteName);
		
		List<Product> allProductsToIndex = prodDataService.getAllProductsBySites(siteIds);
		
		prodElasticRepo.saveAll(allProductsToIndex);
	}

	@Override
	public List<Product> getLast1HourUpdatedData() {
		// TODO Auto-generated method stub
		List<Product> lastOneHourData= prodDataService.getLast1HourUpdatedData();
		prodElasticRepo.saveAll(lastOneHourData);

		return lastOneHourData;
	}

}
