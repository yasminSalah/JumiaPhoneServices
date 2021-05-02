package com.example.dem.dto;

import java.util.Date;

public class HandleExceptionResponseObject {
	
	public static final Date timestamp = new Date();
	public static final String message ="Invalid pageNumber or limit";
	public static final String details ="RequestNotValidException";
	
	private  HandleExceptionResponseObject() {
		
	}
	
	

}
