package com.digisprint.data.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digisprint.data.service.ProductDataService;
import com.digisprint.model.Product;
import com.digisprint.mongo.repository.ProductRepository;

@Service
public class ProductDataServiceImpl implements ProductDataService {

	@Autowired(required = true)
	private ProductRepository productRepo;

	@Override
	public List<Product> getAllProductsBySites(List<String> siteIds) {
		// System.out.println("siteIds "+siteIds);
		List<Product> findAllProducts = productRepo.findByProductWithSites(siteIds);
		// List<Product> findAllProducts = productRepo.findAll();
		findAllProducts.stream().map(prod -> prod.getId()).forEach(System.out::println);
		// System.out.println("******************************");
		return findAllProducts;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public List<Product> getLast1HourUpdatedData() {
		
		return productRepo.findAllByLastmodifiedTime(LocalDateTime.now().minusHours(10));
	}

	}

