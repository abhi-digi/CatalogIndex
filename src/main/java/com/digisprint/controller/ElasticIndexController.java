package com.digisprint.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digisprint.bean.ResponseData;
import com.digisprint.model.Product;
import com.digisprint.service.IndexService;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("rawtypes")
@RestController
@Slf4j
public class ElasticIndexController  extends BaseController{

	@Autowired
	private IndexService indexService;

	@SuppressWarnings("unchecked")
	@PostMapping("/fullIndexing")
	public ResponseEntity<ResponseData> bulkLoadDocument(@RequestBody List<String> siteNames) throws IOException {
		log.debug("Start of ElasticIndexController.bulkLoadDocument() method");
		log.info("Full indexing started...");
		log.debug("Site to Index :: "+siteNames);
		
		StopWatch watch = new StopWatch();
		watch.start();
			List<Product> indexProductData = indexService.indexProductData(siteNames);
		watch.stop();
		log.info("Indexing took :: "+watch.getTotalTimeSeconds() +" seconds ");
		
		Map<String, Object> responseBodyMap = new HashMap<>();
		responseBodyMap.put("Indexing time in sec", watch.getTotalTimeSeconds());
		if(indexProductData != null && !indexProductData.isEmpty()) {
			responseBodyMap.put("Record count :: ", indexProductData.size());
		}else {
			responseBodyMap.put("Record count :: ", 0);
			return failure(responseBodyMap, HttpStatus.NO_CONTENT, "Full indexing failed");
		}
		
		log.debug("End of ElasticIndexController.bulkLoadDocument() method");
		return success(responseBodyMap, HttpStatus.OK, "Full indexing completed");
	}
	

	@SuppressWarnings("unchecked")
	@PostMapping("/partialIndexing")
	public ResponseEntity<ResponseData> partialLoadDocument(@RequestBody List<String> siteNames) throws IOException {
		log.debug("Start of ElasticIndexController.partialLoadDocument() method");
		log.info("Partial indexing started...");
		log.debug("Site to Index :: "+siteNames);
		
		StopWatch watch = new StopWatch();
		watch.start();
			List<Product> indexPartailIndexData = indexService.indexPartailIndexData(siteNames);
		watch.stop();
		log.info("Partial indexing took :: "+watch.getTotalTimeSeconds() +" seconds ");
		
		Map<String, Object> responseBodyMap = new HashMap<>();
		responseBodyMap.put("Indexing time in sec", watch.getTotalTimeSeconds());
		if(indexPartailIndexData != null && !indexPartailIndexData.isEmpty()) {
			responseBodyMap.put("Record count :: ", indexPartailIndexData.size());
		}else {
			responseBodyMap.put("Record count :: ", 0);
			return failure(responseBodyMap, HttpStatus.NO_CONTENT, "Partial indexing failed or No data to index");
		}
		
		log.debug("End of ElasticIndexController.partialLoadDocument() method");
		return success(responseBodyMap, HttpStatus.OK, "Partial indexing completed");
	}
}
