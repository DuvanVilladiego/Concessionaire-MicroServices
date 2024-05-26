package com.formacionbdi.springboot.app.test.querylog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.test.querylog.dto.AuditDto;
import com.formacionbdi.springboot.app.test.querylog.model.Audit;
import com.formacionbdi.springboot.app.test.querylog.model.RequestTransaction;
import com.formacionbdi.springboot.app.test.querylog.repository.AuditRepository;
import com.formacionbdi.springboot.app.test.querylog.services.RegisterAuditService;

@Service
public class RegisterAuditServiceImpl implements RegisterAuditService {

	@Autowired
	private AuditRepository auditRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void databaseInsert(AuditDto audit) {
		auditRepository.save(convertToEntity(audit));
	}

	private Audit convertToEntity(AuditDto dto) {
		Audit audit = modelMapper.map(dto, Audit.class);
		RequestTransaction requestTransaction = modelMapper.map(dto, RequestTransaction.class);
		audit.setRequest(requestTransaction);
		return audit;
	}

}
