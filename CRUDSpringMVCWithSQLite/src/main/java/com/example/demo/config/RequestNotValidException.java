package com.example.demo.config;

public class RequestNotValidException  extends ConnectionErrorException {

	public RequestNotValidException(String message) {
		super(message);
	}
}
