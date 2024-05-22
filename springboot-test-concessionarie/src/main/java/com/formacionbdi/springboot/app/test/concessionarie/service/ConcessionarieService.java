package com.formacionbdi.springboot.app.test.concessionarie.service;

import java.util.List;

import com.formacionbdi.springboot.app.test.concessionarie.dto.ConcessionarieDto;
import com.formacionbdi.springboot.app.test.concessionarie.dto.ConcessionarieWithCarsDto;

public interface ConcessionarieService {

	List<ConcessionarieDto> getAll();
	ConcessionarieWithCarsDto getById(Long id, Long amount);
}
