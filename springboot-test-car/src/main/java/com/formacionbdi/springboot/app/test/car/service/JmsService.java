package com.formacionbdi.springboot.app.test.car.service;

public interface JmsService {
	public void sendMessage(String destination, String message);
}
