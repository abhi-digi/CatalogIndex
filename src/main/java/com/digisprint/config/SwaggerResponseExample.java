package com.digisprint.config;

public interface SwaggerResponseExample {

	String REQUEST_EXAMPLE = "liverpool";
	
	String FULL_INDEXING_RESPONSE_EXAMPLE = "{\r\n"
			+ "  \"message\": \"Full indexing completed\",\r\n"
			+ "  \"success\": true,\r\n"
			+ "  \"statusCode\": 200,\r\n"
			+ "  \"body\": {\r\n"
			+ "    \"Indexing time in sec\": 4.8958481,\r\n"
			+ "    \"Record count :: \": 1623\r\n"
			+ "  }\r\n"
			+ "}";
	String FULL_INDEXING_RESPONSE_FAIL_EXAMPLE = "{\r\n"
			+ "  \"message\": \"Full indexing failed\",\r\n"
			+ "  \"success\": false,\r\n"
			+ "  \"statusCode\": 204,\r\n"
			+ "  \"body\": {\r\n"
			+ "    \"Indexing time in sec\": 0.0170787,\r\n"
			+ "    \"Record count :: \": 0\r\n"
			+ "  }\r\n"
			+ "}";
	
	String PARTIAL_INDEXING_RESPONSE_FAIL_EXAMPLE = "{\r\n"
			+ "  \"message\": \"Partial indexing failed or No data to index\",\r\n"
			+ "  \"success\": false,\r\n"
			+ "  \"statusCode\": 204,\r\n"
			+ "  \"body\": {\r\n"
			+ "    \"Indexing time in sec\": 0.403767601,\r\n"
			+ "    \"Record count :: \": 0\r\n"
			+ "  }\r\n"
			+ "}";
	String PARTIAL_INDEXING_RESPONSE_EXAMPLE = "{\r\n"
			+ "  \"message\": \"Partial indexing completed\",\r\n"
			+ "  \"success\": true,\r\n"
			+ "  \"statusCode\": 200,\r\n"
			+ "  \"body\": {\r\n"
			+ "    \"Indexing time in sec\": 4.8958481,\r\n"
			+ "    \"Record count :: \": 1623\r\n"
			+ "  }\r\n"
			+ "}";

	
}
