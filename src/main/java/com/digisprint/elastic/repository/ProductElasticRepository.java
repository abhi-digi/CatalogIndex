package com.digisprint.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.digisprint.model.Product;

@Repository
public interface ProductElasticRepository extends ElasticsearchRepository<Product, String>{

}
