package com.formacionbdi.springboot.app.test.concessionarie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.app.test.concessionarie.controller.model.ConcessionarieEntity;
import com.formacionbdi.springboot.app.test.concessionarie.controller.model.repository.ConcessionarieRepository;
import com.formacionbdi.springboot.app.test.concessionarie.dto.CarDto;
import com.formacionbdi.springboot.app.test.concessionarie.dto.ConcessionarieDto;
import com.formacionbdi.springboot.app.test.concessionarie.dto.ConcessionarieWithCarsDto;
import com.formacionbdi.springboot.app.test.concessionarie.dto.ResponseDto;
import com.formacionbdi.springboot.app.test.concessionarie.service.ConcessionarieService;
import com.formacionbdi.springboot.app.test.concessionarie.service.JmsService;
import com.formacionbdi.springboot.app.test.concessionarie.util.Constants;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ConcessionarieServiceImpl implements ConcessionarieService {

	@Autowired
	private ConcessionarieRepository repository;

	@Autowired
	private RestTemplate clienteRest;
	
	@Autowired
	private JmsService jmsService;
	
	@Override
	public List<ConcessionarieDto> getAll(String UUID, String serviceName) {
		List<ConcessionarieDto> response =  new ArrayList<ConcessionarieDto>();
		try {
	        response = repository.findAll().stream()
	            .map(p -> new ConcessionarieDto().EntityToDto(p))
	            .collect(Collectors.toList());
	        jmsService.sendMessage(Constants.AUDITORY_QUEUE, serviceName, true, Constants.SUCCES_QUERY, null, UUID);
	    } catch (Exception e) {
	        jmsService.sendMessage(Constants.AUDITORY_QUEUE, serviceName, false, Constants.ERROR_QUERY, e.getMessage(), UUID);         
	    }
		return response;
	}

	@Override
	public ConcessionarieWithCarsDto getById(Long id, Long amount, String UUID, String serviceName) {
	    ConcessionarieWithCarsDto response = new ConcessionarieWithCarsDto();      
	    try {
	        ResponseEntity<ResponseDto<List<CarDto>>> responseEntity = clienteRest.exchange(
	            "http://localhost:8081/api/cars",
	            HttpMethod.GET,
	            null,
	            new ParameterizedTypeReference<ResponseDto<List<CarDto>>>() {}
	        );
	        ResponseDto<List<CarDto>> carsResponse = responseEntity.getBody();

	        if (carsResponse != null && carsResponse.getData() != null) {
	            List<CarDto> limitedCars = carsResponse.getData().stream()
	                                                   .limit(amount)
	                                                   .collect(Collectors.toList());

	            ConcessionarieEntity entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Concessionarie not found"));
	            response = new ConcessionarieWithCarsDto().EntityToDto(entity, limitedCars);
	        }
	        jmsService.sendMessage(Constants.AUDITORY_QUEUE, serviceName, true, Constants.SUCCES_QUERY, null, UUID);
	    } catch (Exception e) {
	        jmsService.sendMessage(Constants.AUDITORY_QUEUE, serviceName, false, Constants.ERROR_QUERY, e.getMessage(), UUID);             
	    }
	    return response;
	}


}
