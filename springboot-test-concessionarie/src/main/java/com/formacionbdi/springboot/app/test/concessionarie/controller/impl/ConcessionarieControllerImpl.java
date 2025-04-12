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
import com.formacionbdi.springboot.app.test.concessionarie.dto.RequestTransactionDto;
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
		RequestTransactionDto request = new RequestTransactionDto(Constants.GET_ALL);
	    String uuid = request.getRequestId();
		ResponseDto<List<ConcessionarieDto>> response = new ResponseDto<List<ConcessionarieDto>>();
		response.setUUID(uuid);
		try {
			response.setData(concessionarieService.getAll(request.getRequestId(), Constants.GET_ALL));
			response.setStatus(true);
			response.setMessage(Constants.SUCCES_QUERY);
		} catch (Exception e) {
			response.setStatus(false);
			response.setMessage(String.format(Constants.ERROR_QUERY, e.getMessage()));
		}
		return response;
	}
	
	@Override
	@GetMapping("/{id}/amount/{amount}")
	public ResponseDto<ConcessionarieWithCarsDto> getConcessionarieById(
	        @PathVariable Long id,
	        @PathVariable Long amount) {
		RequestTransactionDto request = new RequestTransactionDto(Constants.GET_BY_ID);
	    String uuid = request.getRequestId();
	    ResponseDto<ConcessionarieWithCarsDto> response = new ResponseDto<>();
	    response.setUUID(uuid);
	    try {
	        ConcessionarieWithCarsDto concessionarie = concessionarieService.getById(id, amount, uuid, Constants.GET_BY_ID);
	        if (concessionarie.getId() != null) {
	            response.setData(concessionarie);
	            response.setStatus(true);
	            response.setMessage(Constants.SUCCES_QUERY);
	        } else {
	            response.setStatus(false);
	            response.setMessage(String.format(Constants.ERROR_QUERY, Constants.NOT_FOUND_CONCESSIONARIE));
	        }
	    } catch (Exception e) {
	        response.setStatus(false);
	        response.setMessage(String.format(Constants.ERROR_QUERY, e.getMessage()));
	    }
	    return response;
	}

	
}
