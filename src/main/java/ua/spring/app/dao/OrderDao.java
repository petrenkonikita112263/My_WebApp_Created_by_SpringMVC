package ua.spring.app.dao;

import java.sql.Date;

public interface OrderDao {

    void addFlightTicket(String number, int flightId, String text, String startDate,
                         String endDate, double price);

    void removeFlightTicket(int id);

    void editFlightTicket(int id, String number, int flightId, String text, String startDate,
                          String endDate, double price);


    void addOrderTicket(String customerName, Date orderTime, double price,
                        double discount, double finalPrice, int ticketId);
}
