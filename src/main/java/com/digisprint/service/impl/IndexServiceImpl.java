package com.digisprint.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digisprint.data.service.ProductDataService;
import com.digisprint.elastic.repository.ProductElasticRepository;
import com.digisprint.model.Product;
import com.digisprint.service.IndexService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IndexServiceImpl implements IndexService{

	@Autowired(required = true)
	private ProductElasticRepository prodElasticRepo;
	
	@Autowired
	private ProductDataService prodDataService;

	/**
	 * This method get all records from DB and save to ELK.
	 */
	@Override
	public List<Product> indexProductData(List<String> siteNames) {
		log.debug("Start of IndexServiceImpl.indexProductData() method");
		if(siteNames == null || siteNames.isEmpty()) {
			log.info("Must provide site name");
			return new ArrayList<>();
		}
		
		List<Product> allProductsToIndex = prodDataService.getAllProductsBySites(siteNames);
		if(allProductsToIndex != null && !allProductsToIndex.isEmpty()) {
			prodElasticRepo.saveAll(allProductsToIndex);
			log.info("Index record count :: "+allProductsToIndex.size());
		}else {
			log.info("No record indexed, please check");
		}
		
		log.debug("End of IndexServiceImpl.indexProductData() method");
		return allProductsToIndex;
	}
	/**
	 * This method index all the latest updated record to ELK.
	 */
	@Override
	public List<Product> indexPartailIndexData(List<String> siteNames) {
		log.debug("Start of IndexServiceImpl.indexPartailIndexData() method");
		if(siteNames == null || siteNames.isEmpty()) {
			log.info("Must provide site name");
			return new ArrayList<>();
		}
		
		List<Product> latestUpdatedRecord= prodDataService.getLatestUpdatedRecord(siteNames);
		if(latestUpdatedRecord != null && !latestUpdatedRecord.isEmpty()) {
			prodElasticRepo.saveAll(latestUpdatedRecord);
			log.info("Partail index record count :: "+latestUpdatedRecord.size());
		}else {
			log.info("No record indexed, please check any product updated in last 30 minutes");
		}
		
		log.debug("End of IndexServiceImpl.indexPartailIndexData() method");
		return latestUpdatedRecord;
	}

}
