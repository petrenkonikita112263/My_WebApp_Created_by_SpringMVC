package ua.spring.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.spring.app.dao.OrderDao;

import java.sql.Date;
import java.sql.Types;

@Service
public class OrderService implements Orderable {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderDao orderDao;

    @Override
    public void addFlightTicket(String number, int flightId, String text, String startDate,
                                String endDate, String price) {
        orderDao.addFlightTicket(number, flightId, text, startDate, endDate, Double.parseDouble(price));
    }

    @Override
    public void removeFlightTicket(int id) {
        orderDao.removeFlightTicket(id);
    }

    @Override
    public void editFlightTicket(Integer id, String number, int flightId, String text, String startDate,
                                 String endDate, String price) {
        orderDao.editFlightTicket(id, number, flightId, text, startDate, endDate, parseValue(price));
    }

    @Override
    public void buyTicket(String customerName, Date orderTime, String price, String discount, String finalPrice, int ticketId) {
        orderDao.addOrderTicket(customerName, orderTime, parseValue(price),
                parseValue(discount), parseValue(finalPrice), ticketId);
    }

    private double parseValue(String numberValue) {
        try {
            return Double.parseDouble(numberValue);
        } catch (NumberFormatException e) {
            LOGGER.error("The value that was parsed is null", e);
            return Types.DOUBLE;
        }
    }
}
