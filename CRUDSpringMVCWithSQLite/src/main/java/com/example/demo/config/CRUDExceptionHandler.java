package com.example.demo.config;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.example.demo.config.RequestNotValidException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class CRUDExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RequestNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public HandleExceptionResponse handleRequestNotValidException(RequestNotValidException ex, WebRequest request)
			throws Exception {
		log.error("" + ex);
		ex.printStackTrace();
		System.out.println("-----RequestNotValidException-----");
		return new HandleExceptionResponse(new Date(), ex.getMessage(), "RequestNotValidException");
	}

	// NoSuchElementException
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public HandleExceptionResponse handleNoSuchElementException(NoSuchElementException ex, WebRequest request)
			throws Exception {
		log.error("" + ex);
		ex.printStackTrace();
		System.out.println("-----NoSuchElementException-----");
		return new HandleExceptionResponse(new Date(), ex.getMessage(), "NoSuchElementException");
	}

	@ExceptionHandler(ConnectionErrorException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public HandleExceptionResponse handleConstrainViolationException(ConnectionErrorException ex, WebRequest request)
			throws Exception {
		log.error("" + ex);
		ex.printStackTrace();
		System.out.println("----ConstrainViolationException----");
		return new HandleExceptionResponse(new Date(), ex.getMessage(), "500");

	}

	@ExceptionHandler(ResourceItemNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public HandleExceptionResponse handleNotFoundException(ResourceItemNotFoundException ex, WebRequest request)
			throws Exception {
		log.error("" + ex);
		ex.printStackTrace();
		System.out.println("-----ResourceItemNotFoundException-----");
		return new HandleExceptionResponse(new Date(), "ResourceItemNotFoundException", ex.getMessage());
	}
}
