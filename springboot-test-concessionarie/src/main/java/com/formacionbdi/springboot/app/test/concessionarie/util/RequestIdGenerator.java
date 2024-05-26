package com.formacionbdi.springboot.app.test.concessionarie.util;

import java.util.UUID;

public class RequestIdGenerator {
    public static String generateRequestId() {
        return UUID.randomUUID().toString();
    }
}
