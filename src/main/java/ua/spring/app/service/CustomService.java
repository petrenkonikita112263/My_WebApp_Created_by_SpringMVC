package ua.spring.app.service;

import org.springframework.stereotype.Service;
import ua.spring.app.dao.CustomerDao;
import ua.spring.app.entity.Customer;
import ua.spring.app.entity.CustomerOrder;
import ua.spring.app.entity.OrderTicket;
import ua.spring.app.entity.Ticket;

import java.util.List;

/**
 * This class represents a service - a component of a service layer,
 * also implements all the methods from Customable interface
 */
@Service
public class CustomService implements Customable {

    private final CustomerDao customerDao;

    /**
     * Constructor inject of class object.
     */
    public CustomService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeCustomer(int id) {
        customerDao.removeCustomer(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CustomerOrder> getOwnOrderHistory(String username) {
        return customerDao.listOwnOrderHistory(username);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OrderTicket> getOwnOrderTicketHistory(String username) {
        return customerDao.listOwnOrderTicketHistory(username);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Ticket> listTicket() {
        return customerDao.listTicket();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCustomer(String name, String password) {
        customerDao.addCustomer(name, password);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer findById(int id) {
        return customerDao.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCustomerData(int id, String customerName, String customerPassword) {
        customerDao.updateCustomerData(id, customerName, customerPassword);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ticket getFlightTicketById(int id) {
        return customerDao.getFlightTicketById(id);
    }
}
