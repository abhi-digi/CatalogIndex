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
import com.digisprint.config.SwaggerResponseExample;
import com.digisprint.model.Product;
import com.digisprint.service.IndexService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("rawtypes")
@RestController
@Slf4j
public class ElasticIndexController  extends BaseController{

	@Autowired
	private IndexService indexService;

	@SuppressWarnings("unchecked")
	@PostMapping("/fullIndexing")
  @Operation(summary = "This service gives us to full indexing to the data to elasticSearch."
			+ "So based on the name passed in the request body, the full indexing will happen. "
			+ "and the indeced data will be stored in the elastic search server")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Home Page Response", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Object.class), examples = {
					@ExampleObject(name = "HomePage sample for Request body ", value = SwaggerResponseExample.REQUEST_EXAMPLE),
					@ExampleObject(name = "HomePage sample for Passed Response body", value = SwaggerResponseExample.FULL_INDEXING_RESPONSE_EXAMPLE) ,
					@ExampleObject(name = "HomePage sample for failed Response body", value = SwaggerResponseExample.FULL_INDEXING_RESPONSE_FAIL_EXAMPLE) }) }),
			@ApiResponse(responseCode = "400", description = "Invalid import", content = @Content),
			@ApiResponse(responseCode = "404", description = "Data not found", content = @Content) })
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
  
			@Operation(summary = "This service gives us to partially index the data to elasticSearch."
			+ "So based on the name the partial indexing will happen. the data which has updated in last 30 min, that data will be updated in elastic search based on the last modified time.")
		
				@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Home Page Response", content = {
						@Content(mediaType = "application/json", schema = @Schema(implementation = Object.class), examples = {
								@ExampleObject(name = "HomePage sample for Request body ", value =  SwaggerResponseExample.REQUEST_EXAMPLE),
								@ExampleObject(name = "HomePage sample for Passed Response body", value = SwaggerResponseExample.PARTIAL_INDEXING_RESPONSE_EXAMPLE) ,
								@ExampleObject(name = "HomePage sample for failed Response body", value = SwaggerResponseExample.PARTIAL_INDEXING_RESPONSE_FAIL_EXAMPLE) }) }),

				@ApiResponse(responseCode = "500", description = "No content", content = @Content),
			@ApiResponse(responseCode = "204", description = "Partial indexing failed or No data to index", content = @Content) })
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