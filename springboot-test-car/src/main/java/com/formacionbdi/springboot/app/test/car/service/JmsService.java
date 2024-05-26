package com.formacionbdi.springboot.app.test.car.service;

public interface JmsService {
	public void sendMessage(String destination, String serviceName, Boolean status, String message, String error, String UUID);
}
