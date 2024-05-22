package com.formacionbdi.springboot.app.test.concessionarie.service;

public interface JmsService {
	public void sendMessage(String destination, String message);
}
