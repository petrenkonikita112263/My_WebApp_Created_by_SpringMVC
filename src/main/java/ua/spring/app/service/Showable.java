package ua.spring.app.service;

import ua.spring.app.entity.Airport;
import ua.spring.app.entity.Flight;
import ua.spring.app.entity.Plane;

import java.util.List;

public interface Showable {

    List<Airport> getAirportInfo();

    List<Flight> getFlightInfo();

    List<Plane> getPlaneInfo();

}
