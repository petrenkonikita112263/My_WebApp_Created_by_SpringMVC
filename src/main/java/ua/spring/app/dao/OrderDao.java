package ua.spring.app.dao;

import java.sql.Date;

/**
 * Interface class that performs CRUD methods for ticket.
 */
public interface OrderDao {

    /**
     * Method that allow admin to add a new ticket to the flight into database.
     *
     * @param number    ticket number
     * @param flightId  id of the flight
     * @param text      ticket description
     * @param startDate flight date
     * @param endDate   arrival date
     * @param price     ticket price
     */
    void addFlightTicket(String number, int flightId, String text, String startDate,
                         String endDate, double price);

    /**
     * Method that allow admin to delete selected ticket from the database.
     *
     * @param id ticket id
     */
    void removeFlightTicket(int id);

    /**
     * Method that allow admin to change chosen ticket to the flight into database.
     *
     * @param number    ticket number
     * @param flightId  id of the flight
     * @param text      ticket description
     * @param startDate flight date
     * @param endDate   arrival date
     * @param price     ticket price
     */
    void editFlightTicket(int id, String number, int flightId, String text, String startDate,
                          String endDate, double price);

    /**
     * Method that allow customer to buy ticket.
     *
     * @param customerName name of the buyer
     * @param orderTime    the time of booking the ticket
     * @param price        start ticket's price
     * @param discount     discount for ticket if it exists
     * @param finalPrice   final ticket's price including discount
     * @param ticketId     flight ticket id
     */
    void addOrderTicket(String customerName, Date orderTime, double price,
                        double discount, double finalPrice, int ticketId);
}
