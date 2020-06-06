package ua.spring.app.entity.util;

public class DateManager {

    public java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

}
