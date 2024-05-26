package com.formacionbdi.springboot.app.test.querylog.services;

import com.formacionbdi.springboot.app.test.querylog.dto.AuditDto;

public interface RegisterAuditService {

	void databaseInsert(AuditDto audit);

}
