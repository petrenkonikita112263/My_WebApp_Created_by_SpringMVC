package ua.spring.app.dao;

import ua.spring.app.entity.OrderTicket;
import ua.spring.app.entity.Ticket;

import java.sql.Date;
import java.util.List;

public interface OrderDao {

    void addFlightTicket(String number, int flightId, String text, String startDate,
                         String endDate, double price);

    void removeFlightTicket(int id);

    void editFlightTicket(int id, String number, int flightId, String text, String startDate,
                          String endDate, double price);


    void addOrderTicket(String customerName, Date orderTime, double price,
                        double discount, double finalPrice, int ticketId);
}
