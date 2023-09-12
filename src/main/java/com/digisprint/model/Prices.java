package com.digisprint.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prices{
    private String discountPercentage;
    private String listPrice;
    private String salePrice;
    private String promoPrice;
    private String sortPrice;
    
    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
