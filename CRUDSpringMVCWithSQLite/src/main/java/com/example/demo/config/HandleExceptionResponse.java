package com.example.demo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HandleExceptionResponse {

	private Date timestamp;
	private String message;
	private String details;
}
