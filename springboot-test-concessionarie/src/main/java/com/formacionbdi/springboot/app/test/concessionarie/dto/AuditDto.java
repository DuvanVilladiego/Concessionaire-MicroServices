package com.formacionbdi.springboot.app.test.concessionarie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AuditDto extends RequestTransactionDto {

    private Boolean status;
    private String message;

	public AuditDto(String serviceName, Boolean status, String message, String UUID) {
		super(serviceName);
		this.status = status;
		this.message = message;
		this.setRequestId(UUID);
	}
}
