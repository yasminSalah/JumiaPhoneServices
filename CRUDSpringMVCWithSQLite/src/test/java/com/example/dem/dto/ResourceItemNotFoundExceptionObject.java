package com.example.dem.dto;

import java.util.Date;

public class ResourceItemNotFoundExceptionObject {

	public static final Date timestamp = new Date();
	public static final String message = "No Data for Customers Found.";
	public static final String details = "ResourceItemNotFoundException";

	private ResourceItemNotFoundExceptionObject() {

	}

}
