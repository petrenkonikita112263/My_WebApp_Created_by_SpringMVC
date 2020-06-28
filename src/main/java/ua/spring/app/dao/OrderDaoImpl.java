package ua.spring.app.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.SQLException;

import static ua.spring.app.dao.ConstantQuery.*;

@Component
public class OrderDaoImpl extends ManageDb implements OrderDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDaoImpl.class);

    @Override
    public void addFlightTicket(String number, int flightId, String text, String startDate,
                                String endDate, double price) {
        connectDB();
        try {
            ps = connection.prepareStatement(ADD_FLIGHT_TICKET);
            ps.setString(1, number);
            ps.setInt(2, flightId);
            ps.setString(3, text);
            ps.setString(4, startDate);
            ps.setString(5, endDate);
            ps.setDouble(6, price);
            rs = ps.executeQuery();
            LOGGER.info("Ticket was added");
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query", e);
        } finally {
            disconnectDB();
        }
    }

    @Override
    public void removeFlightTicket(int id) {
        try {
            connectDB();
            ps = connection.prepareStatement(DELETE_FLIGHT_TICKET);
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query or wrong column name", e);
        } finally {
            disconnectDB();
        }
    }

    @Override
    public void editFlightTicket(int id, String number, int flightId, String text, String startDate,
                                 String endDate, double price) {
        connectDB();
        try {
            ps = connection.prepareStatement(UPDATE_FLIGHT_TICKET);
            ps.setString(1, number);
            ps.setInt(2, flightId);
            ps.setString(3, text);
            ps.setString(4, startDate);
            ps.setString(5, endDate);
            ps.setDouble(6, price);
            ps.setInt(7, id);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query", e);
        } finally {
            disconnectDB();
        }
    }

    @Override
    public void addOrderTicket(String customerName, Date orderTime, double price,
                               double discount, double finalPrice, int ticketId) {
        connectDB();
        try {
            ps = connection.prepareStatement(PERFORM_ORDER);
            ps.setString(1, customerName);
            ps.setDate(2, orderTime);
            ps.setDouble(3, price);
            ps.setDouble(4, discount);
            ps.setDouble(5, finalPrice);
            ps.setDouble(6, ticketId);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query or wrong column name", e);
        } finally {
            disconnectDB();
        }
    }
}
