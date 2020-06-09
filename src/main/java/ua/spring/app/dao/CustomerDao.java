package ua.spring.app.dao;

import ua.spring.app.entity.Customer;
import ua.spring.app.entity.CustomerOrder;
import ua.spring.app.entity.OrderTicket;
import ua.spring.app.entity.Ticket;

import java.util.List;

public interface CustomerDao {

    List<CustomerOrder> listOwnOrderHistory(String customerName);

    List<OrderTicket> listOwnOrderTicketHistory(String customerName);

    List<Ticket> listTicket();

    List<Customer> getCustomers();

    void removeCustomer(int id);

    void addCustomer(String name, String password);

    Customer findById(int id);

    void updateCustomerData(int id, String name, String password);

    Ticket getFlightTicketById(int id);

}
