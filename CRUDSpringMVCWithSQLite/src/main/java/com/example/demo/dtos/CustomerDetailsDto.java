package com.example.demo.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetailsDto {
	
	long totalCount;
	List<CustomerDto> customers;

}
