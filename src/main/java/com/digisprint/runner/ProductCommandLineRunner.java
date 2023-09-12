package com.digisprint.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.digisprint.data.service.ProductDataService;
import com.digisprint.model.Product;

//@Component
public class ProductCommandLineRunner implements CommandLineRunner{

	@Autowired
	private ProductDataService prodDataService;
	
	@Override
	public void run(String... args) throws Exception {
		List<String> siteIds = new ArrayList<String>();
		siteIds.add("suburbia");
		
		List<Product> allProductsToIndex = prodDataService.getAllProductsBySites(siteIds);
		allProductsToIndex.stream().map(prod ->prod.getId() +" "+
										prod.getVariants().get(0).getSkuId()).forEach(System.out::println);
		System.out.println("liverpool count ::"+allProductsToIndex.size());
	}

}
