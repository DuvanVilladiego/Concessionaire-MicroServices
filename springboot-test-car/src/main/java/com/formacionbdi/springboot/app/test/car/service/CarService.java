package com.formacionbdi.springboot.app.test.car.service;

import java.util.List;

import com.formacionbdi.springboot.app.test.car.dto.CarDto;

public interface CarService {
	
	List<CarDto> getAll(String UUID, String serviceName);
	CarDto getCarById(Long id, String UUID, String serviceName);
	
}
