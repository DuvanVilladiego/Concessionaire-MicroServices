package com.formacionbdi.springboot.app.test.querylog.listeners.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formacionbdi.springboot.app.test.querylog.dto.AuditDto;
import com.formacionbdi.springboot.app.test.querylog.listeners.MessageListener;
import com.formacionbdi.springboot.app.test.querylog.services.RegisterAuditService;
import com.formacionbdi.springboot.app.test.querylog.utils.Constants;

@Component
public class MessageListenerImpl implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(MessageListenerImpl.class);

    @Autowired
    private RegisterAuditService registerAudit;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @JmsListener(destination = Constants.AUDITORY_QUEUE)
    public void receiveCarMessage(String message) {
        try {
            AuditDto auditDto = objectMapper.readValue(message, AuditDto.class);
            processAuditDto(auditDto);
        } catch (JsonMappingException e) {
            logger.error("Error mapping JSON to AuditDto: {}", e.getMessage(), e);
        } catch (JsonProcessingException e) {
            logger.error("Error processing JSON: {}", e.getMessage(), e);
        }
        logger.info("Received message: {}", message);
    }
    
    private void processAuditDto(AuditDto auditDto) {
    	registerAudit.databaseInsert(auditDto);
        logger.info("Processed AuditDto: {}", auditDto);
    }
}
