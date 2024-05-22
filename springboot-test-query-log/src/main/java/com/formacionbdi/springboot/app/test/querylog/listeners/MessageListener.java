package com.formacionbdi.springboot.app.test.querylog.listeners;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.formacionbdi.springboot.app.test.querylog.utils.Constants;

@Component
public class MessageListener {

    @JmsListener(destination = Constants.CAR_QUEUE)
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
