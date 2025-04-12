package com.formacionbdi.springboot.app.test.car.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {

	private Boolean status;
	private String message;
	private String UUID;
	private T data;
	
}
