package com.digisprint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages="com.digisprint.mongo.repository")
@EnableElasticsearchRepositories(basePackages ="com.digisprint.elastic.repository")
public class CatalogIndexApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogIndexApplication.class, args);
	}

}
