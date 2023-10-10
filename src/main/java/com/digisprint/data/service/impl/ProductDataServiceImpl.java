package com.digisprint.data.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.digisprint.data.service.ProductDataService;
import com.digisprint.model.Product;
import com.digisprint.mongo.repository.ProductRepository;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Getter
@Setter
public class ProductDataServiceImpl implements ProductDataService {

	 @Value("${partial.indexing.latest.record.period.minutes}")
	 private long minutes; 

	@Autowired(required = true)
	private ProductRepository productRepo;
	/**
	 * This method fetch all record product collection record from mongoDB.
	 */
	@Override
	public List<Product> getAllProductsBySites(List<String> siteIds) {
		log.debug("Start of ProductDataServiceImpl.getAllProductsBySites() method");
		
		StopWatch watch = new StopWatch();
		watch.start();
		List<Product> findAllProducts = productRepo.findByProductWithSites(siteIds);
		watch.stop();
	
		log.info("Time taken to fetch Product records from mongoDB in seconds :: "+watch.getTotalTimeSeconds());
		log.info("Count of Product record fetch from mongoDB ::" + findAllProducts.size());
		log.debug("List of product record id fetch from mongoDB :: "
				+ findAllProducts.stream().map(prod -> prod.getProductId()).collect(Collectors.toList()));
		log.debug("End of ProductDataServiceImpl.getAllProductsBySites() method");
		return findAllProducts;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	/**
	 * This method fetch all the latest updated records based on time period for Partial indexing..
	 */
	public List<Product> getLatestUpdatedRecord(List<String> siteNames) {
		log.debug("Start of ProductDataServiceImpl.getLatestUpdatedRecord() method");
		
		StopWatch watch = new StopWatch();
		watch.start();
		List<Product> allLatestUpdatedProducts = productRepo.findAllByLastmodifiedTime(siteNames, LocalDateTime.now().minusMinutes(minutes));
		watch.stop();
		
		log.info("Time taken to fetch Product records from mongoDB in seconds :: "+watch.getTotalTimeSeconds());
		log.info("Count of Product record fetch from mongoDB ::" + allLatestUpdatedProducts.size());
		log.debug("List of product record id fetch from mongoDB for Partial Indexing:: "
				+ allLatestUpdatedProducts.stream().map(prod -> prod.getProductId()).collect(Collectors.toList()));
		log.debug("End of ProductDataServiceImpl.getLatestUpdatedRecord() method");
		return allLatestUpdatedProducts;
	}
}

