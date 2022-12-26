package com.igs.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase para registrar logs
 */
public class TestUtils {
    public static final long WAIT = 15;

    public String dateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String dateTimeAmPm() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String date() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public Logger log() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
    }
}
