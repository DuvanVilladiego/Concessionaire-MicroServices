package com.formacionbdi.springboot.app.test.concessionarie.controller;

import java.util.List;

import com.formacionbdi.springboot.app.test.concessionarie.dto.ConcessionarieDto;
import com.formacionbdi.springboot.app.test.concessionarie.dto.ConcessionarieWithCarsDto;
import com.formacionbdi.springboot.app.test.concessionarie.dto.ResponseDto;

public interface ConcessionarieController {

	public ResponseDto<List<ConcessionarieDto>> getAllConcessionarie();
	
	public ResponseDto<ConcessionarieWithCarsDto> getConcessionarieById(Long id, Long cantidad);
	
}
