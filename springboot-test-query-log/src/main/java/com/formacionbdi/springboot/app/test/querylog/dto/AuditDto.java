package com.formacionbdi.springboot.app.test.querylog.dto;

import lombok.AllArgsConstructor;
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
