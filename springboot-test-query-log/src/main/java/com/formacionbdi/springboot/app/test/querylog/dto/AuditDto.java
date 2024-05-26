package com.formacionbdi.springboot.app.test.querylog.dto;

public class AuditDto extends RequestTransactionDto {

    private Boolean status;
    private String message;

	public AuditDto() {}
	
	public AuditDto(String serviceName, Boolean status, String message, String UUID) {
		super(serviceName);
		this.status = status;
		this.message = message;
		this.setRequestId(UUID);
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
