package com.formacionbdi.springboot.app.test.car.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jms.core.JmsTemplate;

import com.formacionbdi.springboot.app.test.car.service.JmsService;

@Service
public class JmsServiceImpl  implements JmsService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMessage(String destination, String message) {
        jmsTemplate.convertAndSend(destination, message);
    }

}
