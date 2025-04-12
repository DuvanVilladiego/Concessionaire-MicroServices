package com.formacionbdi.springboot.app.test.concessionarie.dto;

import com.formacionbdi.springboot.app.test.concessionarie.util.RequestIdGenerator;
import com.formacionbdi.springboot.app.test.concessionarie.util.TimeStampGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestTransactionDto {

    private String serviceName;
    private String requestId;
    private String timestamp;
        
	public RequestTransactionDto(String serviceName) {
		this.serviceName = serviceName;
		this.requestId = RequestIdGenerator.generateRequestId();
		this.timestamp = TimeStampGenerator.getCurrentTimestamp();
	}
	
}
