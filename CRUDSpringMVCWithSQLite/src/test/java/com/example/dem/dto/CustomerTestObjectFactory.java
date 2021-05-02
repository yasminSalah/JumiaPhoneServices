package com.example.dem.dto;

import com.example.demo.config.HandleExceptionResponse;
import com.example.demo.dtos.CustomerDetailsDto;

public class CustomerTestObjectFactory {

	private CustomerTestObjectFactory() {

	}

	public static CustomerDetailsDto testGenerateCustomers() {

		CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();
		customerDetailsDto.setTotalCount(CustomerDetailsDtoMoroccoData.TOTAL_COUNT);
		customerDetailsDto.setCustomers(CustomerDetailsDtoMoroccoData.CUSTOMERS);
		return customerDetailsDto;
	}

	public static CustomerDetailsDto testGenerateNullCustomers() {

		CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();
		customerDetailsDto.setTotalCount(CustomerDetailsDtoMoroccoData.TOTAL_COUNT);
		customerDetailsDto.setCustomers(CustomerDetailsDtoMoroccoData.CUSTOMERS);
		customerDetailsDto=null;
		return customerDetailsDto;
	}
	
	public static HandleExceptionResponse testGenerateCustomersRequestNotValid() {

		HandleExceptionResponse handleExceptionResponse = new HandleExceptionResponse();
		handleExceptionResponse.setMessage(HandleExceptionResponseObject.message);
		handleExceptionResponse.setDetails(HandleExceptionResponseObject.details);
		handleExceptionResponse.setTimestamp(HandleExceptionResponseObject.timestamp);
		return handleExceptionResponse;
	}

	public static HandleExceptionResponse testGenerateCustomersRequestResourceItemNotFound() {

		HandleExceptionResponse handleExceptionResponse = new HandleExceptionResponse();
		handleExceptionResponse.setMessage(ResourceItemNotFoundExceptionObject.message);
		handleExceptionResponse.setDetails(ResourceItemNotFoundExceptionObject.details);
		handleExceptionResponse.setTimestamp(ResourceItemNotFoundExceptionObject.timestamp);
		return handleExceptionResponse;
	}
}
