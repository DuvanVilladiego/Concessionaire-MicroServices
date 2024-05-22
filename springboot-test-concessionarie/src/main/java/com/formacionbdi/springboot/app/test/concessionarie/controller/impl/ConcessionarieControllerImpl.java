package com.formacionbdi.springboot.app.test.concessionarie.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.test.concessionarie.controller.ConcessionarieController;
import com.formacionbdi.springboot.app.test.concessionarie.dto.ConcessionarieDto;
import com.formacionbdi.springboot.app.test.concessionarie.dto.ConcessionarieWithCarsDto;
import com.formacionbdi.springboot.app.test.concessionarie.dto.ResponseDto;
import com.formacionbdi.springboot.app.test.concessionarie.service.ConcessionarieService;
import com.formacionbdi.springboot.app.test.concessionarie.util.Constants;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/concessionaries")
public class ConcessionarieControllerImpl implements ConcessionarieController {

	@Autowired
	private ConcessionarieService concessionarieService;
	
	@Override
	@GetMapping
	public ResponseDto<List<ConcessionarieDto>> getAllConcessionarie() {
		ResponseDto<List<ConcessionarieDto>> response = new ResponseDto<List<ConcessionarieDto>>();
		try {
			response.setData(concessionarieService.getAll());
			response.setStatus(true);
			response.setMessage(Constants.SUCCES_QUERY);
		} catch (Exception e) {
			response.setStatus(false);
			response.setMessage(Constants.ERROR_QUERY);
		}
		return response;
	}
	
	@Override
	@GetMapping("/{id}/cantidad/{amount}")
	public ResponseDto<ConcessionarieWithCarsDto> getConcessionarieById(@PathVariable Long id, @PathVariable Long amount) {
		ResponseDto<ConcessionarieWithCarsDto> response = new ResponseDto<ConcessionarieWithCarsDto>();
		try {
			response.setData(concessionarieService.getById(id, amount));
			response.setStatus(true);
			response.setMessage(Constants.SUCCES_QUERY);
		} catch (Exception e) {
			response.setStatus(false);
			response.setMessage(Constants.ERROR_QUERY);
		}
		return response;
		
	}
	
}
