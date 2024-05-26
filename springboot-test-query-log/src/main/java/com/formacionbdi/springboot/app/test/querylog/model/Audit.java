package com.formacionbdi.springboot.app.test.querylog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value = "Audit")
@Data
public class Audit {
	@Id
	private String id;
    private Boolean status;
    private String message;
    private RequestTransaction request;
    
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
	public RequestTransaction getRequest() {
		return request;
	}
	public void setRequest(RequestTransaction request) {
		this.request = request;
	}

}
