package com.formacionbdi.springboot.app.test.concessionarie.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStampGenerator {

    public static String getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

}
