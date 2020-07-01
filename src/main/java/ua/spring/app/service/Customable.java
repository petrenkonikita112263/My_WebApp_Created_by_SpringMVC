package ua.spring.app.service;

import ua.spring.app.entity.Customer;
import ua.spring.app.entity.CustomerOrder;
import ua.spring.app.entity.OrderTicket;
import ua.spring.app.entity.Ticket;

import java.util.List;

/**
 * Interface class that has all list of operations that perform customer's
 * action or for customer.
 */
public interface Customable {

    /**
     * Method that return ordered history for particular customer's name.
     *
     * @param username customer name
     * @return list of customer's ordered history
     */
    List<CustomerOrder> getOwnOrderHistory(String username);

    /**
     * Method that return ordered ticket's history for
     * particular customer's name.
     *
     * @param username customer name
     * @return list of customer's ordered ticket
     */
    List<OrderTicket> getOwnOrderTicketHistory(String username);

    /**
     * Method that allow every customer to list available tickets.
     *
     * @return list of available tickets
     */
    List<Ticket> listTicket();

    /**
     * Method that allow admin to list existed customers.
     *
     * @return list of existed customers
     */
    List<Customer> getCustomers();

    /**
     * Method that allow admin to remove customer from database.
     *
     * @param id unique id of customer
     */
    void removeCustomer(int id);

    /**
     * Method that allow admin to add new customer into database.
     *
     * @param name     customer name
     * @param password customer password
     */
    void addCustomer(String name, String password);

    /**
     * Method that allow admin to find particular customer in database.
     *
     * @param id unique id of customer
     * @return found customer
     */
    Customer findById(int id);

    /**
     * Method that allow admin to update existed customer in database.
     *
     * @param id               unique id of customer
     * @param customerName     customer name
     * @param customerPassword customer password
     */
    void updateCustomerData(int id, String customerName, String customerPassword);

    /**
     * Method that allow admin to find particular ticket in database.
     *
     * @param id unique id of ticket
     * @return found ticket
     */
    Ticket getFlightTicketById(int id);

}
