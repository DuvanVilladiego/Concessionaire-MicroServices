package com.formacionbdi.springboot.app.test.concessionarie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.test.concessionarie.clients.CarClientRest;
import com.formacionbdi.springboot.app.test.concessionarie.controller.model.repository.ConcessionarieRepository;
import com.formacionbdi.springboot.app.test.concessionarie.dto.CarDto;
import com.formacionbdi.springboot.app.test.concessionarie.dto.ConcessionarieDto;
import com.formacionbdi.springboot.app.test.concessionarie.dto.ConcessionarieWithCarsDto;
import com.formacionbdi.springboot.app.test.concessionarie.service.ConcessionarieService;
import com.formacionbdi.springboot.app.test.concessionarie.service.JmsService;
import com.formacionbdi.springboot.app.test.concessionarie.util.Constants;

@Service
public class ConcessionarieServiceImpl implements ConcessionarieService {

	@Autowired
	private ConcessionarieRepository repository;
	
	@Autowired
	private CarClientRest clienteFeign;
	
	@Autowired
	private JmsService jmsService;
	
	@Override
	public List<ConcessionarieDto> getAll() {
		List<ConcessionarieDto> response =  new ArrayList<ConcessionarieDto>();
		try {
	        response = repository.findAll().stream()
	            .map(p -> new ConcessionarieDto().EntityToDto(p))
	            .collect(Collectors.toList());
	        jmsService.sendMessage(Constants.CONCESSIONARIE_QUEUE, Constants.SUCCES_QUERY);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	System.out.println();
	        jmsService.sendMessage(Constants.CONCESSIONARIE_QUEUE, Constants.ERROR_QUERY);
	    }
		return response;
	}

	@Override
	public ConcessionarieWithCarsDto getById(Long id, Long amount) {
		ConcessionarieWithCarsDto response = new ConcessionarieWithCarsDto();		
		try {
			List<CarDto> cars = clienteFeign.getAllCars().getData();
			List<CarDto> limitedCars = cars.stream().limit(amount).collect(Collectors.toList());
			response = new ConcessionarieWithCarsDto().EntityToDto(repository.findById(id).get(), limitedCars);
			jmsService.sendMessage(Constants.CONCESSIONARIE_QUEUE, Constants.SUCCES_QUERY);
		} catch (Exception e) {
			jmsService.sendMessage(Constants.CONCESSIONARIE_QUEUE, Constants.ERROR_QUERY);			
		}
		return response;
	}

}
