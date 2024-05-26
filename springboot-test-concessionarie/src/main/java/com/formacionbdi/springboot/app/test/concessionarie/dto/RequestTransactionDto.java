package com.formacionbdi.springboot.app.test.concessionarie.dto;

import com.formacionbdi.springboot.app.test.concessionarie.util.RequestIdGenerator;
import com.formacionbdi.springboot.app.test.concessionarie.util.TimeStampGenerator;

public class RequestTransactionDto {

    private String serviceName;
    private String requestId;
    private String timestamp;

	public RequestTransactionDto() {}    
    
	public RequestTransactionDto(String serviceName) {
		this.serviceName = serviceName;
		this.requestId = RequestIdGenerator.generateRequestId();
		this.timestamp = TimeStampGenerator.getCurrentTimestamp();
	}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}
