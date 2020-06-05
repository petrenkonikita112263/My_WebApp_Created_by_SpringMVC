package ua.spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.spring.app.dao.OrderDao;

@Service
public class OrderService implements Orderable {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void addFlightTicket(String number, int flightId, String text, String startDate,
                                String endDate, double price) {
        orderDao.addFlightTicket(number, flightId, text, startDate, endDate, price);
    }

    @Override
    public void removeFlightTicket(int id) {
        orderDao.removeFlightTicket(id);
    }

    @Override
    public void editFlightTicket(Integer id, String number, int flightId, String text, String startDate,
                                 String endDate, double price) {
        orderDao.editFlightTicket(id, number, flightId, text, startDate, endDate, price);
    }
}
