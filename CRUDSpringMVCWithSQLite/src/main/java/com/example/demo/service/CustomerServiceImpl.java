package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.examole.demo.mapper.CustomerMapper;
import com.example.demo.config.ConnectionErrorException;
import com.example.demo.config.RequestNotValidException;
import com.example.demo.config.ResourceItemNotFoundException;
import com.example.demo.dtos.CustomerDetailsDto;
import com.example.demo.dtos.CustomerDto;
import com.example.demo.dtos.DropDownItems;
import com.example.demo.dtos.DropDownList;
import com.example.demo.entity.Customer;
import com.example.demo.repositories.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Iterable<Customer> findAll() {

		return customerRepository.findAll();
	}

	@Override
	public CustomerDetailsDto getAllCustomers(String searchText, int pageNumber, int limit) throws Exception {

		if (pageNumber < 0 || limit <= 0) {
			throw new RequestNotValidException("Invalid pageNumber or limit");
		}
		try {
			log.info("calling ....getAllCustomersService");
			log.info("searchText: " + searchText + ",pageNumber: " + pageNumber + ",limit: " + limit);
			Pageable pageInfo = PageRequest.of(pageNumber, limit);
			long count = customerRepository.count(searchText);
			Page<Customer> customers;
			try {
				customers = customerRepository.findAll(searchText, pageInfo);
			} catch (ResourceItemNotFoundException ex) {
				throw new ResourceItemNotFoundException("No Data for Customers Found.");
			}
			List<CustomerDto> customerdto = CustomerMapper.modelMapper(customers);
			if (searchText.equals("valid")) {

				log.info("searchText:" + searchText);
				return getAllValidCustomers(searchText, pageNumber, limit);
			} else if (searchText.equals("notvalid")) {

				log.info("searchText***:" + searchText);
				return getAllNotvalidCustomers(searchText, pageNumber, limit);
			}

			else {
				CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto(count, customerdto);
				return customerDetailsDto;
			}

		} catch (ConnectionErrorException ex) {
			throw new ConnectionErrorException("Error While Calling Service");
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Phone number is null or empty");
		}
	}

	@Override
	public DropDownList getAvailableDrpodownlistItems() throws Exception {
		log.info("calling ....getAvailableDrpodownlistItemsService");
		try {
			List<DropDownItems> list = new ArrayList();
			list.add(new DropDownItems("Default", ""));
			list.add(new DropDownItems("cameroon", "(237)"));
			list.add(new DropDownItems("ethiopia", "(251)"));
			list.add(new DropDownItems("morocco", "(212)"));
			list.add(new DropDownItems("mozambique", "(258)"));
			list.add(new DropDownItems("uganda", "(256)"));
			list.add(new DropDownItems("Valid", "valid"));
			list.add(new DropDownItems("Not Valid", "notvalid"));
			DropDownList dropDownList = new DropDownList(list);
			return dropDownList;
		} catch (ConnectionErrorException ex) {
			throw new ConnectionErrorException("Error While Calling Service");
		}
	}

	@Override
	public CustomerDetailsDto getAllValidCustomers(String searchText, int pageNumber, int limit) throws Exception {

		log.info("calling ....getAllValidCustomersService");
		try {
			Pageable pageInfo = PageRequest.of(pageNumber, limit);
			Page<Customer> customers = customerRepository.findAll("", pageInfo);
			List<CustomerDto> customerdto = CustomerMapper.validModelMapper(customers);
			long count = customerdto.size();
			CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto(count, customerdto);
			return customerDetailsDto;
		} catch (ConnectionErrorException ex) {
			throw new ConnectionErrorException("Error While Calling Service");
		}
	}

	@Override
	public CustomerDetailsDto getAllNotvalidCustomers(String searchText, int pageNumber, int limit) throws Exception {

		log.info("calling ....getAllNotvalidCustomersService");
		try {
			Pageable pageInfo = PageRequest.of(pageNumber, limit);
			Page<Customer> customers = customerRepository.findAll("", pageInfo);
			List<CustomerDto> customerdto = CustomerMapper.notvalidModelMapper(customers);
			long count = customerdto.size();
			CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto(count, customerdto);
			return customerDetailsDto;
		} catch (ConnectionErrorException ex) {
			throw new ConnectionErrorException("Error While Calling Service");
		}
	}

}
