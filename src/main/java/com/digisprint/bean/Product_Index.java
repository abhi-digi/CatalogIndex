package com.digisprint.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(indexName = "product_index")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product_Index implements Serializable{
	private static final long serialVersionUID = 10001L;
	@Id
    private String id;
    private String title;
    private String sayt_title;
    private String productId;
    private String productDescription;
    private List<String> categoryId;
    private List<String> categoryBreadCrumbs;
    private List<String> ancestors;
    private List<String> typeahead;
    private List<String> relatedCategories;
    private String brand;
    private String SAYT_brand;
    private String creationDate;
    private String department;
    private String brandId;
    private String materialGroup;
    private String productType;
    private String skipInventory;
    private String videoLink;
    private String refundPolicy;
    private String extraInformationWap;
    private String extraInformationWeb;
    private String isMarketPlace;
    private String marketPlaceMessage;
    private List<Object> marketPlaceEDD;
    private String isImportationProduct;
    private String groupType;
    private String rank;
    private String rankB;
    private String rankMKP;
    private String userPurchasedCount;
    private Flags_Index flags;
    private List<Map<String,String>> normalProductFlags;
    private List<Map<String,String>> collectionProductFlags;
    private RatingInfo_Index ratingInfo;
    private String isCollectionProduct;
    private String isHybridProduct;
    private Float minimumListPrice;
    private Float maximumListPrice;
    private Float minimumPromoPrice;
    private Float maximumPromoPrice;
    private List<String> collectionProductIds;
    private List<String> relatedProducts;
    private List<String> productImages;
    private List<String> dynamicAttributes;
    private List<Map<String,List<String>>> dynamicFacets;
    private List<String> productSiteIds;
    private String isVariant;
    private List<String> swatchColors;
    private List<Variant_Index> variants;
    private Set<String> inStockStores;
    private Set<String> geoStoreIds;
    private String promotionalGiftMessage;
    private Object ebookInfo;
    private String callRecommendCarousel;
    private String hemService;
    private String isSustainable;
    private List<Map<String,List<String>>> dynamicAttributeSearch;
    
    private String comfortService;
    private String comfortServiceCost;
    private String comfortServiceAddress;
    private String warrantyService;
    private String warrantyServiceCost;
    private String warrantyServiceAddress;
    private String warrantyPeriod;
    private String serviceCombo;
    private String lastmodifiedTime;
    private String lastmodifiedByWhom;
    private String considerForTypeahead;
    private String refubrished;
    private String isAccessory;


    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product_Index other = (Product_Index) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
}
