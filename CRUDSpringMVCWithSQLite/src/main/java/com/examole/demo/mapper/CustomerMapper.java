package com.examole.demo.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import com.example.demo.dtos.CustomerDto;
import com.example.demo.dtos.PhoneDetails;
import com.example.demo.entity.Customer;
import com.example.demo.enums.CountryRegex;
import com.example.demo.service.CustomerServiceImpl;

public class CustomerMapper {

	@Autowired
	CustomerServiceImpl customerService;

	public static List<CustomerDto> modelMapper(Page<Customer> customers) throws NoSuchElementException {

		List<CustomerDto> customerdto = new ArrayList();

		for (Customer c : customers) {

			PhoneDetails PhoneDetails = getPhoneDetails(c.getPhone());

			CustomerDto customerDto = new CustomerDto();
			customerDto.setName(c.getName());
			customerDto.setPhone(PhoneDetails.getPhoneNumber());
			customerDto.setCountryCode(PhoneDetails.getCountryCode());
			customerDto.setCountryName(PhoneDetails.getCountryName());
			customerDto.setStatus(PhoneDetails.getStatus());
			customerdto.add(customerDto);
		}
		return customerdto;
	}

	public static List<CustomerDto> validModelMapper(Page<Customer> customers) throws NoSuchElementException {

		List<CustomerDto> customerdto = new ArrayList();

		for (Customer c : customers) {

			PhoneDetails PhoneDetails = getPhoneDetails(c.getPhone());
			CustomerDto customerDto = new CustomerDto();
			customerDto.setName(c.getName());
			customerDto.setPhone(PhoneDetails.getPhoneNumber());
			customerDto.setCountryCode(PhoneDetails.getCountryCode());
			customerDto.setCountryName(PhoneDetails.getCountryName());
			if (PhoneDetails.getStatus() == "Valid") {
				customerDto.setStatus(PhoneDetails.getStatus());
				customerdto.add(customerDto);
			}

		}
		return customerdto;
	}

	public static List<CustomerDto> notvalidModelMapper(Page<Customer> customers) throws NoSuchElementException {

		List<CustomerDto> customerdto = new ArrayList();

		for (Customer c : customers) {

			PhoneDetails PhoneDetails = getPhoneDetails(c.getPhone());
			CustomerDto customerDto = new CustomerDto();
			customerDto.setName(c.getName());
			customerDto.setPhone(PhoneDetails.getPhoneNumber());
			customerDto.setCountryCode(PhoneDetails.getCountryCode());
			customerDto.setCountryName(PhoneDetails.getCountryName());
			if (PhoneDetails.getStatus() == "Not Valid") {
				customerDto.setStatus(PhoneDetails.getStatus());
				customerdto.add(customerDto);
			}

		}
		return customerdto;
	}

	private static PhoneDetails getPhoneDetails(String Phone) throws NoSuchElementException {
		if (Phone == null || Phone.isEmpty()) {
			throw new NoSuchElementException("Phone number not found ");
		}
		PhoneDetails phoneDetails = new PhoneDetails();
		phoneDetails.setPhoneNumber(Phone.substring(Phone.indexOf(")") + 1));
		phoneDetails.setCountryCode(Phone.substring(Phone.indexOf("(") + 1, Phone.indexOf(")")));
		String countryCode = Phone.substring(Phone.indexOf("(") + 1, Phone.indexOf(")"));
		if (countryCode.equals("237")) {
			phoneDetails.setCountryName("Cameroon");
			boolean s = validatePhoneNumberByCountryPattern(CountryRegex.Cameroon_REGEX.getText(), Phone);
			if (s == true) {
				phoneDetails.setStatus("Valid");
			} else {
				phoneDetails.setStatus("Not Valid");
			}
		} else if (countryCode.equals("251")) {
			phoneDetails.setCountryName("Ethiopia");
			boolean s = validatePhoneNumberByCountryPattern(CountryRegex.Ethiopia_REGEX.getText(), Phone);
			if (s) {
				phoneDetails.setStatus("Valid");
			} else {
				phoneDetails.setStatus("Not Valid");
			}
		} else if (countryCode.equals("212")) {
			phoneDetails.setCountryName("Morocco");
			boolean s = validatePhoneNumberByCountryPattern(CountryRegex.Morocco_REGEX.getText(), Phone);
			if (s == true) {
				phoneDetails.setStatus("Valid");
			} else {
				phoneDetails.setStatus("Not Valid");
			}
		} else if (countryCode.equals("258")) {
			phoneDetails.setCountryName("Mozambique");
			boolean s = validatePhoneNumberByCountryPattern(CountryRegex.Mozambique_REGEX.getText(), Phone);

			if (s == true) {
				phoneDetails.setStatus("Valid");
			} else {
				phoneDetails.setStatus("Not Valid");
			}
		} else if (countryCode.equals("256")) {
			phoneDetails.setCountryName("Uganda");
			boolean s = validatePhoneNumberByCountryPattern(CountryRegex.Uganda.getText(), Phone);

			if (s == true) {
				phoneDetails.setStatus("Valid");
			} else {
				phoneDetails.setStatus("Not Valid");
			}
		}
		return phoneDetails;

	}

	public static boolean validatePhoneNumberByCountryPattern(String regex, String Phone) {

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(Phone);
		boolean s = matcher.matches();
		if (s == true) {
			return true;
		} else {
			return false;
		}
	}

}
