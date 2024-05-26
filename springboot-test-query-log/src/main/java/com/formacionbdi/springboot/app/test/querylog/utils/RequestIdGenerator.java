package com.formacionbdi.springboot.app.test.querylog.utils;

import java.util.UUID;

public class RequestIdGenerator {
    public static String generateRequestId() {
        return UUID.randomUUID().toString();
    }
}
