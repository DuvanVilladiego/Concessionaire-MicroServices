package com.formacionbdi.springboot.app.test.car.utils;

import java.util.UUID;

public class RequestIdGenerator {
    public static String generateRequestId() {
        return UUID.randomUUID().toString();
    }
}
