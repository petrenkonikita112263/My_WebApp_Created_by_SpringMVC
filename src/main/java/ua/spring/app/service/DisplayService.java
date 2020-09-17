package ua.spring.app.service;

import org.springframework.stereotype.Service;
import ua.spring.app.dao.Displayable;
import ua.spring.app.entity.Airport;
import ua.spring.app.entity.Flight;
import ua.spring.app.entity.Plane;

import java.util.List;

/**
 * This class represents a service - a component of a service layer,
 * also implements all the methods from Showable interface.
 */
@Service
public class DisplayService implements Showable {

    private final Displayable additionalDao;

    /**
     * Constructor inject of displayable dao object.
     */
    public DisplayService(Displayable additionalDao) {
        this.additionalDao = additionalDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Airport> getAirportInfo() {
        return additionalDao.getAirportInfo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Flight> getFlightInfo() {
        return additionalDao.getFlightInfo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Plane> getPlaneInfo() {
        return additionalDao.getPlaneInfo();
    }
}
