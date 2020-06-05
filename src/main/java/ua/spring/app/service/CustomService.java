package ua.spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.spring.app.dao.CustomerDao;
import ua.spring.app.entity.Customer;
import ua.spring.app.entity.CustomerOrder;
import ua.spring.app.entity.OrderTicket;
import ua.spring.app.entity.Ticket;

import java.util.List;

@Service
public class CustomService implements Customable {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void removeCustomer(int id) {
        customerDao.removeCustomer(id);
    }

    @Override
    public List<CustomerOrder> listCustomerOrder() {
        return customerDao.listCustomerOrder();
    }

    @Override
    public List<OrderTicket> listOrderTicket() {
        return customerDao.listOrderTicket();
    }

    @Override
    public List<Ticket> listTicket() {
        return customerDao.listTicket();
    }

    @Override
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @Override
    public void addCustomer(String name, String password) {
        customerDao.addCustomer(name, password);
    }

    @Override
    public Customer findById(int id) {
        return customerDao.findById(id);
    }

    @Override
    public void updateCustomerData(int id, String customerName, String customerPassword) {
        customerDao.updateCustomerData(id, customerName, customerPassword);
    }

    @Override
    public Ticket getFlightTicketById(int id) {
        return customerDao.getFlightTicketById(id);
    }
}
