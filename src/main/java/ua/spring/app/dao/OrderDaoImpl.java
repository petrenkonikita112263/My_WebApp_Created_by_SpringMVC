package ua.spring.app.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.SQLException;

@Component
public class OrderDaoImpl extends ManageDb implements OrderDao {

    private static final Logger LOGGER = Logger.getLogger(OrderDaoImpl.class);

//    @Override
//    public void makeOrder(int orderId, int customerOrderId, int ticketId) {
//        try {
//            manageDb.connectDB();
//            ps = connection.prepareStatement("INSERT INTO ORDER_TICKET(ORDER_ID, CUSTOMER_ORDER_ID, TICKET_ID) "
//                    + "VALUES (ticket_order_seq.nextval, customer_order_help_seq.nextval, ticket_seq.nextval");
//            rs = ps.executeQuery();
//        } catch (SQLException e) {
//            LOGGER.error("Invalid sql query or wrong column name", e);
//        } finally {
//            manageDb.disconnectDB();
//        }
//    }
//
//    @Override
//    public List<OrderTicket> getFullOrderHistory() {
//        List<OrderTicket> orders = new ArrayList<>();
//        try {
//            manageDb.connectDB();
//            ps = connection.prepareStatement("SELECT * FROM ORDER_TICKET");
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                orders.add(parseOrders(rs));
//            }
//        } catch (SQLException e) {
//            LOGGER.error("Invalid sql query", e);
//        } finally {
//            manageDb.disconnectDB();
//        }
//        return orders;
//    }
//
//    private OrderTicket parseOrders(ResultSet resultSet) {
//        OrderTicket orderTicket = null;
//        int orderId;
//        int customerOrderId;
//        int ticketId;
//        try {
//            orderId = resultSet.getInt("ORDER_ID");
//            customerOrderId = resultSet.getInt("CUSTOMER_ORDER_ID");
//            ticketId = resultSet.getInt("TICKET_ID");
//            orderTicket = new OrderTicket(orderId, customerOrderId, ticketId);
//        } catch (SQLException e) {
//            LOGGER.error("Wrong column name", e);
//        }
//        return orderTicket;
//    }
//
//    @Override
//    public void removerOrder(int id) {
//        try {
//            manageDb.connectDB();
//            ps = connection.prepareStatement("DELETE ORDER_TICKET WHERE ORDER_ID = ?");
//            ps.setInt(1, id);
//            rs = ps.executeQuery();
//        } catch (SQLException e) {
//            LOGGER.error("Invalid sql query or wrong column name", e);
//        } finally {
//            manageDb.disconnectDB();
//        }
//    }
//
//    @Override
//    public OrderTicket getOrderHistory(int id) {
//        OrderTicket orderTicket = null;
//        try {
//            manageDb.connectDB();
//            ps = connection.prepareStatement("SELECT * FROM ORDER_TICKET WHERE ORDER_ID = ?");
//            ps.setInt(1, id);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                orderTicket = parseOrders(rs);
//            }
//        } catch (SQLException e) {
//            LOGGER.error("Invalid sql query", e);
//        } finally {
//            manageDb.disconnectDB();
//        }
//        return orderTicket;
//    }
//
//    @Override
//    public void editOrder(int orderId, int customerOrderId, int ticketId) {
//        try {
//            manageDb.connectDB();
//            ps = connection.prepareStatement("UPDATE ORDER_TICKET SET CUSTOMER_ORDER_ID = ?, TICKET_ID = ? WHERE ORDER_ID = ?");
//            if (customerOrderId == 0) {
//                ps.setNull(1, Types.INTEGER);
//            } else {
//                ps.setInt(1, customerOrderId);
//            }
//            if (ticketId == 0) {
//                ps.setNull(2, Types.INTEGER);
//            } else {
//                ps.setInt(2, ticketId);
//            }
//            if (orderId == 0) {
//                ps.setNull(3, Types.INTEGER);
//            } else {
//                ps.setInt(3, orderId);
//            }
//            rs = ps.executeQuery();
//        } catch (SQLException e) {
//            LOGGER.error("Invalid sql query or wrong column name", e);
//        } finally {
//            manageDb.disconnectDB();
//        }
//    }
//
//    @Override
//    public void addFlightTicket(int id, String number, int flightId, String text, String startDate, String endDate, double price) {
//        try {
//            manageDb.connectDB();
//            ps = connection.prepareStatement("INSERT INTO TICKET(TICKET_ID, SERIAL_NUMBER, " +
//                    "FLIGHT_ID, DESCRIPTION, FLIGHT_DATE, ARRIVAL_DATE, PRICE) " +
//                    "VALUES (ticket_seq.nextval, ?, flight_seq.nextval, ?, ?, ?, ?) ");
//            ps.setString(1, number);
//            ps.setString(2, text);
//            ps.setString(3, startDate);
//            ps.setString(4, endDate);
//            ps.setDouble(5, price);
//            rs = ps.executeQuery();
//        } catch (SQLException e) {
//            LOGGER.error("Invalid sql query or wrong column name", e);
//        } finally {
//            manageDb.disconnectDB();
//        }
//    }
//
//    @Override
//    public List<Ticket> getFlightTickets() {
//        List<Ticket> tickets = new ArrayList<>();
//        try {
//            manageDb.connectDB();
//            ps = connection.prepareStatement("SELECT * FROM TICKET");
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                tickets.add(parseTicket(rs));
//            }
//        } catch (SQLException e) {
//            LOGGER.error("Invalid sql query", e);
//        } finally {
//            manageDb.disconnectDB();
//        }
//        return tickets;
//    }
//
//    private Ticket parseTicket(ResultSet resultSet) {
//        Ticket ticket = null;
//        int ticketId;
//        String serialNumber;
//        int flightId;
//        String description;
//        String flightDate;
//        String arrivalDate;
//        double price;
//        try {
//            ticketId = resultSet.getInt("TICKET_ID");
//            serialNumber = resultSet.getString("SERIAL_NUMBER");
//            flightId = resultSet.getInt("FLIGHT_ID");
//            description = resultSet.getString("DESCRIPTION");
//            flightDate = resultSet.getString("FLIGHT_DATE");
//            arrivalDate = resultSet.getString("ARRIVAL_DATE");
//            price = resultSet.getDouble("PRICE");
//            ticket = new Ticket(ticketId, serialNumber, flightId, description,
//                    flightDate, arrivalDate, price);
//        } catch (SQLException e) {
//            LOGGER.error("Wrong column name", e);
//        }
//        return ticket;
//    }
//
//    @Override
//    public void removeFlightTicket(int id) {
//        try {
//            manageDb.connectDB();
//            ps = connection.prepareStatement("DELETE TICKET WHERE TICKET_ID = ?");
//            ps.setInt(1, id);
//            rs = ps.executeQuery();
//        } catch (SQLException e) {
//            LOGGER.error("Invalid sql query or wrong column name", e);
//        } finally {
//            manageDb.disconnectDB();
//        }
//    }
//
//    @Override
//    public Ticket getFlightTicket(int id) {
//        Ticket ticket = null;
//        try {
//            manageDb.connectDB();
//            ps = connection.prepareStatement("SELECT * FROM TICKET WHERE TICKET_ID = ?");
//            ps.setInt(1, id);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                ticket = parseTicket(rs);
//            }
//        } catch (SQLException e) {
//            LOGGER.error("Invalid sql query", e);
//        } finally {
//            manageDb.disconnectDB();
//        }
//        return ticket;
//    }
//
//    @Override
//    public void editFlightTicket(int id, String number, int flightId, String text, String startDate, String endDate, double price) {
//        try {
//            manageDb.connectDB();
//            ps = connection.prepareStatement("UPDATE TICKET SET SERIAL_NUMBER = ?, FLIGHT_ID = ?," +
//                    " DESCRIPTION = ?, FLIGHT_DATE = ?, ARRIVAL_DATE = ?, PRICE = ? WHERE TICKET_ID = ?");
//            ps.setString(1, number);
//            if (flightId == 0) {
//                ps.setNull(2, Types.INTEGER);
//            } else {
//                ps.setInt(2, flightId);
//            }
//            ps.setString(3, text);
//            ps.setString(4, startDate);
//            ps.setString(5, endDate);
//            ps.setDouble(6, price);
//            if (id == 0) {
//                ps.setNull(7, Types.INTEGER);
//            } else {
//                ps.setInt(7, id);
//            }
//            rs = ps.executeQuery();
//        } catch (SQLException e) {
//            LOGGER.error("Invalid sql query or wrong column name", e);
//        } finally {
//            manageDb.disconnectDB();
//        }
//    }


    @Override
    public void addFlightTicket(String number, int flightId, String text, String startDate,
                                String endDate, double price) {
        connectDB();
        try {
            ps = connection.prepareStatement("INSERT INTO LAB3PN_TICKET(TICKET_ID, SERIAL_NUMBER, FLIGHT_ID, " +
                    "DESCRIPTION, FLIGHT_DATE, ARRIVAL_DATE, PRICE) " +
                    "VALUES(LAB3PN_TICKET_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)");
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
            ps = connection.prepareStatement("UPDATE LAB3PN_TICKET " +
                    "SET SERIAL_NUMBER = ?, FLIGHT_ID = ?, DESCRIPTION = ?, FLIGHT_DATE = ?, " +
                    "ARRIVAL_DATE = ?, PRICE = ? WHERE TICKET_ID = ?");
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
