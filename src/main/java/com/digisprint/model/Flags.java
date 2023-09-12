package com.digisprint.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flags{
    private String isPresale;
    private String presaleStartDate;
    private String presaleEndDate;
    private String isExclusiveProduct;
    private String exclusiveProductStartDate;
    private String exclusiveProductEndDate;
    private String isExclusivePromotion;
    private String exclusivePromotionStartDate;
    private String exclusivePromotionEndDate;
    private String isExpressDelivery;
    private String expressDeliveryStartDate;
    private String expressDeliveryEndDate;
    private String isLatestParts;
    private String latestPartsStartDate;
    private String latestPartsEndDate;
    private String isExclusivePackage;
    private String exclusivePackageStartDate;
    private String exclusivePackageEndDate;
    private String isExclusiveDiscount;
    private String exclusiveDiscountStartDate;
    private String exclusiveDiscountEndDate;
    private String isGiftPurchase;
    private String giftPurchaseStartDate;
    private String giftPurchaseEndDate;
    private String isShipPleasant;
    private String shipPleasantStartDate;
    private String shipPleasantEndDate;
    private String isExclusivePrice;
    private String exclusivePriceStartDate;
    private String exclusivePriceEndDate;
    private String isNewProduct;
    private String newProductStartDate;
    private String newProductEndDate;
    private String isLimitedPieces;
    private String limitedPiecesStartDate;
    private String limitedPiecesEndDate;
    private String isDeliveryOnlyStore;
    private String deliveryOnlyStoreStartDate;
    private String deliveryOnlyStoreEndDate;
    private String isAvailabilityShop;
    private String availabilityShopStartDate;
    private String availabilityShopEndDate;
    private String isElectronicPurse;
    private String electronicPurseStartDate;
    private String electronicPurseEndDate;
    private String isRelease;
    private String releaseStartDate;
    private String releaseEndDate;
    
    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
