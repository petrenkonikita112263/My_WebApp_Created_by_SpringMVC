package ua.spring.app.dao;

import ua.spring.app.entity.OrderTicket;
import ua.spring.app.entity.Ticket;

import java.util.List;

public interface OrderDao {

//    void makeOrder(int orderId, int customerOrderId, int ticketId);
//
//    void removerOrder(int id);
//
//    OrderTicket getOrderHistory(int id);
//
//    void editOrder(int orderId, int customerOrderId, int ticketId);

    void addFlightTicket(String number, int flightId, String text, String startDate,
                         String endDate, double price);

//    List<Ticket> getFlightTickets();

    void removeFlightTicket(int id);

//    Ticket getFlightTicket(int id);

    void editFlightTicket(int id, String number, int flightId, String text, String startDate,
                          String endDate, double price);


    //    void addOrderTicket(int orderId, int customerId, Date orderTime, double price,
//                        double discount, double finalPrice);
//
//    List<OrderTicket> listOrders();
//
//    void removeOrderTicket(int id);
//
//    OrderTicket getOrder(int id);
//
//    void editOrderTicket(int orderId, int customerId, Date orderTime, double price,
//                         double discount, double finalPrice);

}
