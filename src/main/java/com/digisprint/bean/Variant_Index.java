package com.digisprint.bean;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Variant_Index{
    private String skuId;
    private String skuName;
    private String skuDescription;
    private String model;
    private String uom;
    private String gtin;
    private String isbnId;
    private String spbId;
    private String dimensions;
    private String material;
    private String texture;
    private String isBundle;
    private String bundleMessage;
    private String specialSaleMessage;
    private String supplierId;
    private String externalId;
    private String opticsAxis;
    private String opticsBaseCurve;
    private String opticsColor;
    private String opticsCylinder;
    private String opticsDiameter;
    private String opticsPower;
    private String size;
    private String cloneNormalizedSize;
    private String color;
    private String colorhex;
    private String normalizedHex;
    private String normalizedColor;
    private String normalizedSize;
    private int sellersCount;
    private int variantSequence;
    private List<String> galleriaImages;
    private String colorImage;
    private String smallImage;
    private String largeImage;
    private String thumbnailImage;
    private String onSale;
    private List<String> sellerNameAndId;
    private List<String> sellernames;
    private String bestofferId;
    private String dWPromoDescription;
    private String dwToolTipInfo;
    private String dWCollectionProductMessage;
    private String hasValidOnlineInventory;
    private String hasHybridSeller;
    private Prices_Index prices;
    private Prices_Index lpPrices;
    private List<Promo_Index> liverpoolPromotions;
    private List<Promo_Index> otherPromotions;
    private List<Offer_Index> offers;
    private List<Promo_Index> catalogLiverpoolPromotions;
    private List<Promo_Index> catalogOtherPromotions;
    private List<Promo_Index> sellerLiverpoolPromotions;
    private List<Promo_Index> sellerOtherPromotions;
    private String newArrival;
    private String newArrivalReadable;
    
    
    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
