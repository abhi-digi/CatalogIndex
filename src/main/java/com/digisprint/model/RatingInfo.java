package com.digisprint.model;
import org.apache.commons.lang3.builder.ToStringBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingInfo{
    private String oneRatingCount;
    private String oneRatingPercentage;
    private String twoRatingPercentage;
    private String threeRatingPercentage;
    private String fourRatingPercentage;
    private String fiveRatingPercentage;
    private String productAvgRating;
    private String productRatingCount;
    private String twoRatingCount;
    private String threeRatingCount;
    private String fourRatingCount;
    private String fiveRatingCount;
    
    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
  }
}

