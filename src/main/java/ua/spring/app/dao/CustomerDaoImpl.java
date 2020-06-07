package ua.spring.app.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ua.spring.app.entity.Customer;
import ua.spring.app.entity.CustomerOrder;
import ua.spring.app.entity.OrderTicket;
import ua.spring.app.entity.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDaoImpl extends ManageDb implements CustomerDao {

    private static final Logger LOGGER = Logger.getLogger(CustomerDaoImpl.class);

    @Override
    public void removeCustomer(int id) {
        try {
            connectDB();
            ps = connection.prepareStatement("DELETE LAB3PN_USERS WHERE CUSTOMER_ID = ? AND AUTHORITY LIKE 'ROLE_CUSTOMER'");
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query or wrong column name", e);
        } finally {
            disconnectDB();
        }
    }

    @Override
    public List<OrderTicket> listOwnOrderTicketHistory(String customerName) {
        List<OrderTicket> orders = new ArrayList<>();
        try {
            connectDB();
            ps = connection.prepareStatement("SELECT * FROM LAB3PN_ORDER_TICKET WHERE CUSTOMER_ORDER_ID = "
                    + "(SELECT CUSTOMER_ORDER_ID FROM LAB3PN_CUSTOMER_ORDER WHERE CUSTOMER_ID = "
                    + "(SELECT CUSTOMER_ID FROM LAB3PN_USERS WHERE USERNAME LIKE ?) AND ROWNUM = 1)");
            ps.setString(1, customerName);
            rs = ps.executeQuery();
            OrderTicket orderTicket;
            while (rs.next()) {
                orderTicket = parseOrderTicket(rs);
                orders.add(orderTicket);
            }
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query", e);
        } finally {
            disconnectDB();
        }
        return orders;
    }

    private OrderTicket parseOrderTicket(ResultSet resultSet) {
        OrderTicket orderTicket = new OrderTicket();
        try {
            orderTicket.setOrderId(resultSet.getInt("ORDER_ID"));
            orderTicket.setCustomerOrderId(resultSet.getInt("CUSTOMER_ORDER_ID"));
            orderTicket.setTicketId(resultSet.getInt("TICKET_ID"));
        } catch (SQLException e) {
            LOGGER.error("Wrong column name", e);
        }
        return orderTicket;
    }

    @Override
    public List<CustomerOrder> listOwnOrderHistory(String customerName) {
        List<CustomerOrder> customerOrders = new ArrayList<>();
        try {
            connectDB();
            ps = connection.prepareStatement("SELECT * FROM LAB3PN_CUSTOMER_ORDER WHERE CUSTOMER_ID = "
                    + "(SELECT CUSTOMER_ID FROM LAB3PN_USERS WHERE USERNAME = ?)");
            ps.setString(1, customerName);
            rs = ps.executeQuery();
            CustomerOrder customerOrder;
            while (rs.next()) {
                customerOrder = parseCustomerOrder(rs);
                customerOrders.add(customerOrder);
            }
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query", e);
        } finally {
            disconnectDB();
        }
        return customerOrders;
    }

    private CustomerOrder parseCustomerOrder(ResultSet resultSet) {
        CustomerOrder customerOrder = new CustomerOrder();
        try {
            customerOrder.setCustomerOrderId(resultSet.getInt("CUSTOMER_ORDER_ID"));
            customerOrder.setCustomerId(resultSet.getInt("CUSTOMER_ID"));
            customerOrder.setOrderTime(resultSet.getDate("ORDER_TIME"));
            customerOrder.setPrice(resultSet.getDouble("PRICE"));
            customerOrder.setDiscount(resultSet.getDouble("DISCOUNT"));
            customerOrder.setDiscount(resultSet.getDouble("FINAL_PRICE"));
        } catch (SQLException e) {
            LOGGER.error("Wrong column name", e);
        }
        return customerOrder;
    }

    @Override
    public List<Ticket> listTicket() {
        List<Ticket> tickets = new ArrayList<>();
        connectDB();
        try {
            ps = connection.prepareStatement("SELECT * FROM LAB3PN_TICKET");
            rs = ps.executeQuery();
            Ticket ticket;
            while (rs.next()) {
                ticket = parseTicket(rs);
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query", e);
        } finally {
            disconnectDB();
        }
        return tickets;
    }

    private Ticket parseTicket(ResultSet resultSet) {
        Ticket ticket = new Ticket();
        try {
            ticket.setTicketId(resultSet.getInt("TICKET_ID"));
            ticket.setSerialNumber(resultSet.getString("SERIAL_NUMBER"));
            ticket.setFlightId(resultSet.getInt("FLIGHT_ID"));
            ticket.setDescription(resultSet.getString("DESCRIPTION"));
            ticket.setFlightDate(resultSet.getString("FLIGHT_DATE"));
            ticket.setArrivalDate(resultSet.getString("ARRIVAL_DATE"));
            ticket.setPrice(resultSet.getDouble("PRICE"));
        } catch (SQLException e) {
            LOGGER.error("Wrong column name", e);
        }
        return ticket;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            connectDB();
            ps = connection.prepareStatement("SELECT * FROM LAB3PN_USERS WHERE AUTHORITY LIKE 'ROLE_CUSTOMER'");
            rs = ps.executeQuery();
            Customer customer;
            while (rs.next()) {
                customer = parseCustomer(rs);
                customers.add(customer);
            }
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query", e);
        } finally {
            disconnectDB();
        }
        return customers;
    }

    private Customer parseCustomer(ResultSet resultSet) {
        Customer customer = new Customer();
        try {
            customer.setId(resultSet.getInt("CUSTOMER_ID"));
            customer.setUserName(resultSet.getString("USERNAME"));
            customer.setPassword(resultSet.getString("PASSWORD"));
            customer.setRole(resultSet.getString("AUTHORITY"));
            customer.setEnable(resultSet.getInt("ENABLED"));
        } catch (SQLException e) {
            LOGGER.error("Wrong column name", e);
        }
        return customer;
    }

    @Override
    public void addCustomer(String name, String password) {
        connectDB();
        try {
            ps = connection.prepareStatement("INSERT INTO LAB3PN_USERS(CUSTOMER_ID, USERNAME, PASSWORD, AUTHORITY, ENABLED)\n" +
                    "VALUES(LAB3PN_USERS_SEQ.NEXTVAL, ?, ?, 'ROLE_CUSTOMER', 1)");
            ps.setString(1, name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            LOGGER.info("Customer was added");
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query", e);
        } finally {
            disconnectDB();
        }
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        connectDB();
        try {
            ps = connection.prepareStatement("SELECT * FROM LAB3PN_USERS WHERE CUSTOMER_ID = ? AND AUTHORITY LIKE 'ROLE_CUSTOMER'");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                customer = parseCustomer(rs);
            }
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query", e);
        } finally {
            disconnectDB();
        }
        return customer;
    }

    @Override
    public void updateCustomerData(int id, String customerName, String customerPassword) {
        connectDB();
        try {
            ps = connection.prepareStatement("UPDATE LAB3PN_USERS " +
                    "SET USERNAME = ?, PASSWORD = ? WHERE CUSTOMER_ID = ?");
            ps.setString(1, customerName);
            ps.setString(2, customerPassword);
            ps.setInt(3, id);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query", e);
        } finally {
            disconnectDB();
        }
    }


    @Override
    public Ticket getFlightTicketById(int id) {
        Ticket ticket = null;
        connectDB();
        try {
            ps = connection.prepareStatement("SELECT * FROM LAB3PN_TICKET WHERE TICKET_ID = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ticket = parseTicket(rs);
            }
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query", e);
        } finally {
            disconnectDB();
        }
        return ticket;
    }
}
