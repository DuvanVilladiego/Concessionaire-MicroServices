package com.formacionbdi.springboot.app.test.car.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.test.car.dto.CarDto;
import com.formacionbdi.springboot.app.test.car.model.repository.CarRepository;
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
	public List<CarDto> getAll(String UUID, String serviceName) {
		List<CarDto> response =  new ArrayList<CarDto>();
		try {
	        response = repository.findAll().stream()
	            .map(p -> new CarDto().EntityToDto(p))
	            .collect(Collectors.toList());
	        jmsService.sendMessage(Constants.AUDITORY_QUEUE, serviceName, true, Constants.SUCCES_QUERY, null, UUID);
	    } catch (Exception e) {
	        jmsService.sendMessage(Constants.AUDITORY_QUEUE, serviceName, false, Constants.ERROR_QUERY, e.getMessage(), UUID);         
	    }
		return response;
	}

	@Override
	public CarDto getCarById(Long id, String UUID, String serviceName) {
		CarDto response = new CarDto();		
		try {
			response = new CarDto().EntityToDto(repository.findById(id).get());
			if (response != null) {
		        jmsService.sendMessage(Constants.AUDITORY_QUEUE, serviceName, true, Constants.SUCCES_QUERY, null, UUID);
			} else {
		        jmsService.sendMessage(Constants.AUDITORY_QUEUE, serviceName, false, Constants.ERROR_QUERY, Constants.NOT_FOUND_CAR, UUID);         
			}
		} catch (Exception e) {
	        jmsService.sendMessage(Constants.AUDITORY_QUEUE, serviceName, false, Constants.ERROR_QUERY, e.getMessage(), UUID);         
		}
		return response;
	}

}
