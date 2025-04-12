package com.formacionbdi.springboot.app.test.concessionarie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDto {

	private Long id;
	private String nombre;
	private Double precio;
	
}
