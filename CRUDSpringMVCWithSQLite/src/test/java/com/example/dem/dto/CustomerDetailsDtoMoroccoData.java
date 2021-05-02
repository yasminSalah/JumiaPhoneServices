package com.example.dem.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.example.demo.dtos.CustomerDto;


public class CustomerDetailsDtoMoroccoData {

	/*
	 {
    "totalCount": 7,
    "customers": [
        {
            "name": "Walid Hammadi",
            "phone": " 6007989253",
            "countryCode": "212",
            "countryName": "Morocco",
            "status": "Not Valid"
        },
        {
            "name": "Yosaf Karrouch",
            "phone": " 698054317",
            "countryCode": "212",
            "countryName": "Morocco",
            "status": "Valid"
        },
        {
            "name": "Younes Boutikyad",
            "phone": " 6546545369",
            "countryCode": "212",
            "countryName": "Morocco",
            "status": "Not Valid"
        },
        {
            "name": "Houda Houda",
            "phone": " 6617344445",
            "countryCode": "212",
            "countryName": "Morocco",
            "status": "Not Valid"
        },
        {
            "name": "Chouf Malo",
            "phone": " 691933626",
            "countryCode": "212",
            "countryName": "Morocco",
            "status": "Valid"
        },
        {
            "name": "soufiane fritisse ",
            "phone": " 633963130",
            "countryCode": "212",
            "countryName": "Morocco",
            "status": "Valid"
        },
        {
            "name": "Nada Sofie",
            "phone": " 654642448",
            "countryCode": "212",
            "countryName": "Morocco",
            "status": "Valid"
        }
    ]
}
	 * */
	public static final long TOTAL_COUNT = 7;
	public static final List<CustomerDto> CUSTOMERS = Stream
			.of(new CustomerDto("Walid Hammadi", " 6007989253", "212", "Morocco", "Not Valid"),
					new CustomerDto("Yosaf Karrouch", " 698054317", "212", "Morocco", "Valid"),
					new CustomerDto("Younes Boutikyad", " 6007989253", "212", "Morocco", "Valid"),
					new CustomerDto("Houda Houda", " 6617344445", "212", "Morocco", "Not Valid"),
					new CustomerDto("Chouf Malo", " 691933626", "212", "Morocco", "Valid"),
					new CustomerDto("soufiane fritisse ", " 633963130", "212", "Morocco", "Valid"),
					new CustomerDto("Nada Sofie", " 654642448", "212", "Morocco", "Valid"))
			.collect(Collectors.toList());

	private CustomerDetailsDtoMoroccoData() {
	}

}
