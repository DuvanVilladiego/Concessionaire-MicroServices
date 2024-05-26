package com.formacionbdi.springboot.app.test.car.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jms.core.JmsTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formacionbdi.springboot.app.test.car.dto.AuditDto;
import com.formacionbdi.springboot.app.test.car.service.JmsService;

@Service
public class JmsServiceImpl  implements JmsService {
	
    private static final Logger logger = LoggerFactory.getLogger(JmsServiceImpl.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Override
    public void sendMessage(String destination, String serviceName, Boolean status, String message, String error, String uuid) {
        String auditMessage = String.format(message, error);
        String queueMessage;
        try {
            queueMessage = objectMapper.writeValueAsString(generateAuditDto(serviceName, status, auditMessage, uuid));
            jmsTemplate.convertAndSend(destination, queueMessage);
        } catch (JsonProcessingException e) {
            logger.error("Error serializing AuditDto: {}", e.getMessage(), e);
        }
    }
    
    private AuditDto generateAuditDto(String serviceName, Boolean status, String message, String UUID) {
    	return new AuditDto(serviceName, status, message, UUID);
    }

}
