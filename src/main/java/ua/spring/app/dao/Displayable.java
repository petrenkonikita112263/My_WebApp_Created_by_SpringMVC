package ua.spring.app.dao;

import ua.spring.app.entity.Airport;
import ua.spring.app.entity.Flight;
import ua.spring.app.entity.Plane;

import java.util.List;

/**
 * Interface class that holds shown methods.
 */
public interface Displayable {

    /**
     * Method display all existed airports in the database.
     *
     * @return list of airports
     */
    List<Airport> getAirportInfo();

    /**
     * Method display all existed flights in the database.
     *
     * @return list of flighs
     */
    List<Flight> getFlightInfo();

    /**
     * Method display all existed planes in the database.
     *
     * @return list of planes
     */
    List<Plane> getPlaneInfo();

}
