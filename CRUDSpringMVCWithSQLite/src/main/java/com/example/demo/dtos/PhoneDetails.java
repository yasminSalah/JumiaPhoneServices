package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDetails {

	private String phoneNumber;
	private String countryCode;
	private String  countryName;
	private String status;
}
