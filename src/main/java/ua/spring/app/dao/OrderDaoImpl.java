package ua.spring.app.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.SQLException;

@Component
public class OrderDaoImpl extends ManageDb implements OrderDao {

    private static final Logger LOGGER = Logger.getLogger(OrderDaoImpl.class);

    @Override
    public void addFlightTicket(String number, int flightId, String text, String startDate,
                                String endDate, double price) {
        connectDB();
        try {
            ps = connection.prepareStatement("INSERT INTO LAB3PN_TICKET(TICKET_ID, SERIAL_NUMBER, FLIGHT_ID, "
                    + "DESCRIPTION, FLIGHT_DATE, ARRIVAL_DATE, PRICE) "
                    + "VALUES(LAB3PN_TICKET_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)");
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
            ps = connection.prepareStatement("DELETE LAB3PN_TICKET WHERE TICKET_ID = ?");
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
            ps = connection.prepareStatement("UPDATE LAB3PN_TICKET "
                    + "SET SERIAL_NUMBER = ?, FLIGHT_ID = ?, DESCRIPTION = ?, FLIGHT_DATE = ?, "
                    + "ARRIVAL_DATE = ?, PRICE = ? WHERE TICKET_ID = ?");
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
            ps = connection.prepareStatement("BEGIN INSERT INTO LAB3PN_CUSTOMER_ORDER(CUSTOMER_ORDER_ID, CUSTOMER_ID, "
                    + "ORDER_TIME, PRICE, DISCOUNT, FINAL_PRICE) VALUES (LAB3PN_CUSTOMER_SEQ.NEXTVAL, "
                    + "(SELECT CUSTOMER_ID FROM LAB3PN_USERS WHERE LAB3PN_USERS.USERNAME = ?), "
                    + "?, ?, ?, ?); INSERT INTO LAB3PN_ORDER_TICKET(ORDER_ID, CUSTOMER_ORDER_ID, TICKET_ID) VALUES (LAB3PN_ORDER_SEQ.NEXTVAL, LAB3PN_CUSTOMER_SEQ.currval, ?); END;");
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
