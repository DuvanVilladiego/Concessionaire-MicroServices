package com.formacionbdi.springboot.app.test.concessionarie.dto;

public class ResponseDto<T> {

	private Boolean status;
	private String message;
	private T data;
	
	public ResponseDto() {
	}
	
	public ResponseDto(Boolean status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
