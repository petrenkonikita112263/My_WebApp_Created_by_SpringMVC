package ua.spring.app.entity.util;

import java.sql.Date;

public class DateManager {

    public static Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new Date(today.getTime());
    }

}
