package com.example.demo.service;

import com.example.demo.dtos.CustomerDetailsDto;
import com.example.demo.dtos.DropDownList;
import com.example.demo.entity.Customer;

public interface CustomerService {

	public Iterable<Customer> findAll();

	public CustomerDetailsDto getAllCustomers(String searchText, int pageNumber, int limit) throws Exception;

	public DropDownList getAvailableDrpodownlistItems() throws Exception;

	public CustomerDetailsDto getAllValidCustomers(String searchText, int pageNumber, int limit) throws Exception;

	public CustomerDetailsDto getAllNotvalidCustomers(String searchText, int pageNumber, int limit) throws Exception;

}
