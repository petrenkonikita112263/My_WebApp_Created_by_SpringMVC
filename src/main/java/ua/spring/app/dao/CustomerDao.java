package ua.spring.app.dao;

import ua.spring.app.entity.Customer;
import ua.spring.app.entity.CustomerOrder;
import ua.spring.app.entity.OrderTicket;
import ua.spring.app.entity.Ticket;

import java.util.List;

/**
 * Interface class that hold methods for customer and operations on customer.
 */
public interface CustomerDao {

    /**
     * Display history of made ordered the customer.
     *
     * @param customerName customer's name
     * @return list of purchases that were made
     */
    List<CustomerOrder> listOwnOrderHistory(String customerName);

    /**
     * Display history of booked flight ticket for customer.
     *
     * @param customerName customer's name
     * @return list of booked tickets
     */
    List<OrderTicket> listOwnOrderTicketHistory(String customerName);

    /**
     * Display all tickets to the plane stored in the database.
     *
     * @return list of tickets
     */
    List<Ticket> listTicket();

    /**
     * Display all customers stored in the database.
     *
     * @return list of customers
     */
    List<Customer> getCustomers();

    /**
     * Remove selected customer from database.
     *
     * @param id customer's number
     */
    void removeCustomer(int id);

    /**
     * Add new customer to the database
     *
     * @param name     customer's name
     * @param password customer's password
     */
    void addCustomer(String name, String password);

    /**
     * Display specific customer into screen.
     *
     * @param id customer's number
     * @return chosen customer by number
     */
    Customer findById(int id);

    /**
     * Updated existed customer in the database.
     *
     * @param id       customer's number
     * @param name     new customer's name
     * @param password new customer's password
     */
    void updateCustomerData(int id, String name, String password);

    /**
     * Display specific ticket into screen.
     *
     * @param id ticket's number
     * @return chosem ticket by id(number)
     */
    Ticket getFlightTicketById(int id);

}
