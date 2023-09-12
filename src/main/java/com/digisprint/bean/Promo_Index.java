package com.digisprint.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Promo_Index {
	private String promoCode;
	private String promoType;
	private String discountAmount;
	private String months;
	private String promoDesc;

}
