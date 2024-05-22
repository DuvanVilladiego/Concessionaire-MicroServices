package com.formacionbdi.springboot.app.test.concessionarie.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacionbdi.springboot.app.test.concessionarie.dto.CarDto;
import com.formacionbdi.springboot.app.test.concessionarie.dto.ResponseDto;


@FeignClient(name = "test-car-service")
public interface CarClientRest {

	@GetMapping
	public ResponseDto<List<CarDto>> getAllCars();

	@GetMapping("/{id}")
	public ResponseDto<CarDto> getCarById(@PathVariable Long id);

}
