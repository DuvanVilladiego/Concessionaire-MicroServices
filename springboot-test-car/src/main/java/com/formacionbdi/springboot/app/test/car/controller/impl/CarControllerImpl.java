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
import com.formacionbdi.springboot.app.test.car.dto.RequestTransactionDto;
import com.formacionbdi.springboot.app.test.car.dto.ResponseDto;
import com.formacionbdi.springboot.app.test.car.service.CarService;
import com.formacionbdi.springboot.app.test.car.utils.Constants;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/cars")
public class CarControllerImpl implements CarController {

	@Autowired
	private CarService carService;
	
	@Override
	@GetMapping
	public ResponseDto<List<CarDto>> getAllCars() {
		RequestTransactionDto request = new RequestTransactionDto(Constants.GET_ALL);
		ResponseDto<List<CarDto>> response = new ResponseDto<List<CarDto>>();
		response.setUUID(request.getRequestId());
		try {
			response.setData(carService.getAll(request.getRequestId(), Constants.GET_ALL));
			response.setStatus(true);
			response.setMessage(Constants.SUCCES_QUERY);
		} catch (Exception e) {
			response.setStatus(false);
			response.setMessage(String.format(Constants.ERROR_QUERY, e.getMessage()));
		}
		return response;
	}
	
	@Override
	@GetMapping("/{id}")
	public ResponseDto<CarDto> getCarById(@PathVariable Long id) {
		RequestTransactionDto request = new RequestTransactionDto(Constants.GET_BY_ID);
		ResponseDto<CarDto> response = new ResponseDto<CarDto>();
		response.setUUID(request.getRequestId());
		try {
			CarDto car = carService.getCarById(id, request.getRequestId(), Constants.GET_BY_ID);
			if (car.getId()!=null) {
				response.setData(car);
				response.setStatus(true);
				response.setMessage(Constants.SUCCES_QUERY);
			} else {
				response.setStatus(false);
				response.setMessage(String.format(Constants.ERROR_QUERY, Constants.NOT_FOUND_CAR));
			}
		} catch (Exception e) {
			response.setStatus(false);
			response.setMessage(String.format(Constants.ERROR_QUERY, e.getMessage()));
		}
		return response;
	}
	
}
