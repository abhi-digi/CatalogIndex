package com.digisprint.mongo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.digisprint.model.Product;

@EnableMongoRepositories
public interface ProductRepository extends MongoRepository<Product, String>{
	
	  @Query(value ="{'productSiteIds':{$in:?0}}",
			  fields="{'id':1,'title':1,'productDescription':1,'brand':1,'categoryId':1,'categoryBreadCrumbs':1,'productType':1,'department':1,'skipInventory':1, 'isCollectionProduct':1,'refubrished':1, 'materialGroup':1,"
			  		+ "'variants.skuId':1,'variants.prices':1,'variants.color':1,'variants.thumbnailImage':1,'variants.galleriaImages':1,"
			  		+ "'variants.size':1,'variants.gtin':1,'variants.inventory':1,'variants.preOrderInventory':1,'variants.offers.offerId':1,'variants.offers.stock':1,'maximumListPrice':1,"
			  		+"'minimumListPrice':1,'minimumPromoPrice':1,'maximumPromoPrice':1}")
	  List<Product> findByProductWithSites(List<String> siteIds);
	   
	  
	  @Query(value ="{ 'productSiteIds':{$in:?0},'lastmodifiedTime' : { $gte : ?1 } }",
			  fields="{'id':1,'title':1,'productDescription':1,'brand':1,'categoryId':1,'categoryBreadCrumbs':1,'productType':1,'department':1,'skipInventory':1, 'isCollectionProduct':1,'refubrished':1, 'materialGroup':1,"+
					  "'variants.skuId':1,'variants.prices':1,'variants.color':1,'variants.thumbnailImage':1,'variants.galleriaImages':1,'variants.size':1,'variants.gtin':1,'variants.inventory':1,'variants.preOrderInventory':1,"+
					  "'variants.offers.offerId':1,'variants.offers.stock':1,'lastmodifiedTime':1,'maximumListPrice':1,"+
					  "'minimumListPrice':1,'minimumPromoPrice':1,'maximumPromoPrice':1}")
	 List<Product> findAllByLastmodifiedTime(List<String> siteIds ,LocalDateTime timeBefore);
}
