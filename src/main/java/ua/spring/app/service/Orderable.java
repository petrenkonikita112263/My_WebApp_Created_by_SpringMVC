package ua.spring.app.service;

import java.sql.Date;

public interface Orderable {

    void addFlightTicket(String number, int flightId, String text, String startDate,
                         String endDate, double price);

    void removeFlightTicket(int id);

    void editFlightTicket(Integer id, String number, int flightId, String text, String startDate,
                          String endDate, double price);

    void buyTicket(String customerName, Date orderTime, String price,
                        String discount, String finalPrice);

}
