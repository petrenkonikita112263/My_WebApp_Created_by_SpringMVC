package ua.spring.app.service;

import java.sql.Date;

/**
 * Interface class that has all list of operations that perform
 * CRUD actions with ticket.
 */
public interface Orderable {

    /**
     * Method that allow admin to add new ticket for plane into database.
     *
     * @param number    ticket number
     * @param flightId  the id of particular flight
     * @param text      description (additional info)
     * @param startDate the flight date from specific airport
     * @param endDate   the arrival date to the endpoint airport
     * @param price     ticket price
     */
    void addFlightTicket(String number, int flightId, String text, String startDate,
                         String endDate, String price);

    /**
     * Method that allow admin to delete specific ticket from database.
     *
     * @param id - unique ticket number
     */
    void removeFlightTicket(int id);

    /**
     * Method that allow admin edit the existed tickets.
     *
     * @param id        set the id of ticket which gonna be changed
     * @param number    new ticket number
     * @param flightId  new id of particular flight
     * @param text      new description
     * @param startDate new flight date
     * @param endDate   new arrival date
     * @param price     new ticket price
     */
    void editFlightTicket(Integer id, String number, int flightId, String text, String startDate,
                          String endDate, String price);

    /**
     * Method that provides an opportunity for customer to perform buying
     * operations.
     *
     * @param customerName customer name
     * @param orderTime    precise time of orders
     * @param price        start price
     * @param discount     discount if there's one
     * @param finalPrice   price that includes discount
     * @param ticketId     the id of particular ticket
     */
    void buyTicket(String customerName, Date orderTime, String price,
                   String discount, String finalPrice, int ticketId);
}
