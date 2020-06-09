package ua.spring.app.service;

import ua.spring.app.entity.Customer;
import ua.spring.app.entity.CustomerOrder;
import ua.spring.app.entity.OrderTicket;
import ua.spring.app.entity.Ticket;

import java.util.List;

public interface Customable {

    List<CustomerOrder> getOwnOrderHistory(String username);

    List<OrderTicket> getOwnOrderTicketHistory(String username);

    List<Ticket> listTicket();

    List<Customer> getCustomers();

    void removeCustomer(int id);

    void addCustomer(String name, String password);

    Customer findById(int id);

    void updateCustomerData(int id, String customerName, String customerPassword);

    Ticket getFlightTicketById(int id);

}
