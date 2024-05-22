package com.formacionbdi.springboot.app.test.car.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.test.car.controller.CarController;
import com.formacionbdi.springboot.app.test.car.dto.CarDto;
import com.formacionbdi.springboot.app.test.car.dto.ResponseDto;
import com.formacionbdi.springboot.app.test.car.service.CarService;
import com.formacionbdi.springboot.app.test.car.utils.Constants;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/cars")
public class CarControllerImpl implements CarController {

	@Autowired
	private CarService carService;
	
	@GetMapping
	@Override
	public ResponseDto<List<CarDto>> getAllCars() {
		ResponseDto<List<CarDto>> response = new ResponseDto<List<CarDto>>();
		try {
			response.setData(carService.getAll());
			response.setStatus(true);
			response.setMessage(Constants.SUCCES_QUERY);
		} catch (Exception e) {
			response.setStatus(false);
			response.setMessage(Constants.ERROR_QUERY);
		}
		return response;
	}
	
	@GetMapping("/{id}")
	@Override
	public ResponseDto<CarDto> getCarById(@PathVariable Long id) {
		ResponseDto<CarDto> response = new ResponseDto<CarDto>();
		try {
			response.setData(carService.getCarById(id));
			response.setStatus(true);
			response.setMessage(Constants.SUCCES_QUERY);
		} catch (Exception e) {
			response.setStatus(false);
			response.setMessage(Constants.ERROR_QUERY);
		}
		return response;
	}
	
}
