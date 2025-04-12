package com.formacionbdi.springboot.app.test.car.dto;

import com.formacionbdi.springboot.app.test.car.model.CarEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

	private Long id;
	private String nombre;
	private Double precio;
		
	public CarDto EntityToDto(CarEntity entity) {
		return new CarDto(entity.getId(), entity.getName(), entity.getPrecio());
	}
}
