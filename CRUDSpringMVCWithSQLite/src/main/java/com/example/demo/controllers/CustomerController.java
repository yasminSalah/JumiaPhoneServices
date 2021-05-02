package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CustomerDetailsDto;
import com.example.demo.dtos.DropDownList;
import com.example.demo.dtos.PagedRequestBody;
import com.example.demo.service.CustomerService;

//@Controller
//@RequestMapping(value = {"", "phone"})
/////////////////////////////////////////

@RestController
@RequestMapping("Customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	// http://localhost:9090/Customer/info
	@RequestMapping(value = "info", method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("products", customerService.findAll());
		return "phone/index";
	}

	// http://localhost:9090/Customer/all
	@CrossOrigin
	@PostMapping(path = "/all", consumes = "application/json", produces = "application/json")
	public CustomerDetailsDto getAllCustomers(@RequestBody PagedRequestBody request) throws Exception {

		return customerService.getAllCustomers(request.getSearchText(), request.getPageNumber(), request.getLimit());
	}

	@CrossOrigin
	@GetMapping("/GetAllItems")
	public DropDownList getAllAvailableItems() throws Exception {
		return customerService.getAvailableDrpodownlistItems();
	}
}
