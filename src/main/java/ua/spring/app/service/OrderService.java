package ua.spring.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.spring.app.dao.OrderDao;

import java.sql.Date;
import java.sql.Types;

/**
 * This class represents a service - a component of a service layer,
 * also implements all the methods from Orderable interface.
 */
@Service
public class OrderService implements Orderable {

    /**
     * Constant for this class that add logging functionality.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    /**
     * Field inject of orderDao object.
     */
    @Autowired
    private OrderDao orderDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public void addFlightTicket(String number, int flightId, String text, String startDate,
                                String endDate, String price) {
        orderDao.addFlightTicket(number, flightId, text, startDate, endDate, Double.parseDouble(price));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeFlightTicket(int id) {
        orderDao.removeFlightTicket(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void editFlightTicket(Integer id, String number, int flightId, String text, String startDate,
                                 String endDate, String price) {
        orderDao.editFlightTicket(id, number, flightId, text, startDate, endDate, parseValue(price));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void buyTicket(String customerName, Date orderTime, String price, String discount, String finalPrice, int ticketId) {
        orderDao.addOrderTicket(customerName, orderTime, parseValue(price),
                parseValue(discount), parseValue(finalPrice), ticketId);
    }

    /**
     * Additional method that parse String to Double, and if the String has null value,
     * then it returns next Double.
     *
     * @param numberValue string value equals to number
     * @return double value
     */
    private double parseValue(String numberValue) {
        try {
            return Double.parseDouble(numberValue);
        } catch (NumberFormatException e) {
            LOGGER.error("The value that was parsed is null", e);
            return Types.DOUBLE;
        }
    }
}
