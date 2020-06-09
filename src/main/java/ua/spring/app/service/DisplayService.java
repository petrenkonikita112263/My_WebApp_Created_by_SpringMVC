package ua.spring.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.spring.app.dao.Displayable;
import ua.spring.app.entity.Airport;
import ua.spring.app.entity.Flight;
import ua.spring.app.entity.Plane;

import java.util.List;

@Service
public class DisplayService implements Showable {

    @Autowired
    private Displayable additionalDao;

    @Override
    public List<Airport> getAirportInfo() {
        return additionalDao.getAirportInfo();
    }

    @Override
    public List<Flight> getFlightInfo() {
        return additionalDao.getFlightInfo();
    }

    @Override
    public List<Plane> getPlaneInfo() {
        return additionalDao.getPlaneInfo();
    }
}
