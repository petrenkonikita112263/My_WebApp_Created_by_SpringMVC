package ua.spring.app.service;

import ua.spring.app.entity.Airport;
import ua.spring.app.entity.Flight;
import ua.spring.app.entity.Plane;

import java.util.List;

/**
 * Interface class that has all list of operations that perform shown actions.
 */
public interface Showable {

    /**Display list of airports.
     * @return list of airports*/
    List<Airport> getAirportInfo();

    /**Display list of flights.
     * @return list of flights*/
    List<Flight> getFlightInfo();

    /**Display list of planes.
     * @return list of planes*/
    List<Plane> getPlaneInfo();

}
