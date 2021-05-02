package com.example.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CountryRegex {
	
	    Cameroon_REGEX("\\(237\\)\\ ?[2368]\\d{7,8}$"),
	    Ethiopia_REGEX("\\(251\\)\\ ?[1-59]\\d{8}$"),
	    Morocco_REGEX("\\(212\\)\\ ?[5-9]\\d{8}$"),
	    Mozambique_REGEX("\\(258\\)\\ ?[28]\\d{7,8}$"),
	    Uganda("\\(256\\)\\ ?\\d{9}$")
	    ;

	    private final String text;

}
