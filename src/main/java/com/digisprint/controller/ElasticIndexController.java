package com.digisprint.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digisprint.service.IndexService;

@RestController
public class ElasticIndexController {

	@Autowired
	private IndexService indexService;

	@PostMapping("/bulkLoad")
	public ResponseEntity<Object> bulkLoadDocument(@RequestParam String siteName) throws IOException {
		indexService.indexProductData(siteName);
		return new ResponseEntity<>("Bulk load indexing completed", HttpStatus.OK);
	}
}
