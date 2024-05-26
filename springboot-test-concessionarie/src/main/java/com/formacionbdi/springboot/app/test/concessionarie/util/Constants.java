package com.formacionbdi.springboot.app.test.concessionarie.util;

public class Constants {
	/*SERVICE NAMES*/
	public static final String GET_ALL = "GET_ALL_CONCESSIONARIES";
	public static final String GET_BY_ID = "GET_CONCESSIONARIE_BY_ID";
	
	/*QUEUES*/
	public static final String AUDITORY_QUEUE = "AUDITORY_QUEUE";

	/*MESSAGES*/
	public static final String SUCCES_QUERY = "SUCCESS QUERY";
	public static final String ERROR_QUERY = "ERROR QUERY, CAUSE: %s";
	
	public static final String NOT_FOUND_CONCESSIONARIE = "CONCESSIONARIE NOT FOUND";
}
