package com.formacionbdi.springboot.app.test.car.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.test.car.controller.model.repository.CarRepository;
import com.formacionbdi.springboot.app.test.car.dto.CarDto;
import com.formacionbdi.springboot.app.test.car.service.CarService;
import com.formacionbdi.springboot.app.test.car.service.JmsService;
import com.formacionbdi.springboot.app.test.car.utils.Constants;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository repository;
	
	@Autowired
	private JmsService jmsService;
	
	@Override
	public List<CarDto> getAll() {
		List<CarDto> response =  new ArrayList<CarDto>();
		try {
	        response = repository.findAll().stream()
	            .map(p -> new CarDto().EntityToDto(p))
	            .collect(Collectors.toList());
	        jmsService.sendMessage(Constants.CAR_QUEUE, Constants.SUCCES_QUERY);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	System.out.println();
	        jmsService.sendMessage(Constants.CAR_QUEUE, Constants.ERROR_QUERY);
	    }
		return response;
	}

	@Override
	public CarDto getCarById(Long id) {
		CarDto response = new CarDto();		
		try {
			response = new CarDto().EntityToDto(repository.findById(id).get());
			jmsService.sendMessage(Constants.CAR_QUEUE, Constants.SUCCES_QUERY);
		} catch (Exception e) {
			jmsService.sendMessage(Constants.CAR_QUEUE, Constants.ERROR_QUERY);			
		}
		return response;
	}

}
