package com.formacionbdi.springboot.app.test.car.controller;

import java.util.List;

import com.formacionbdi.springboot.app.test.car.dto.CarDto;
import com.formacionbdi.springboot.app.test.car.dto.ResponseDto;

public interface CarController {
	
	public ResponseDto<List<CarDto>> getAllCars();
	public ResponseDto<CarDto> getCarById(Long id);

}
