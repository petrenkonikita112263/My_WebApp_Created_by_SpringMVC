package ua.spring.app.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ua.spring.app.entity.Airport;
import ua.spring.app.entity.Flight;
import ua.spring.app.entity.Plane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.spring.app.dao.ConstantQuery.*;

/**
 * Class that displays additional info from the database extends ManageDb
 * and implements its own interface.
 *
 * @Component annotate our component class
 */
@Component
public class DisplayDao extends ManageDb implements Displayable {

    /**
     * Constant for this class that add logging functionality.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DisplayDao.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Airport> getAirportInfo() {
        List<Airport> airports = new ArrayList<>();
        connectDB();
        try {
            ps = connection.prepareStatement(VIEW_AIRPORT_LIST);
            rs = ps.executeQuery();
            Airport airport;
            while (rs.next()) {
                airport = parseAirport(rs);
                airports.add(airport);
            }
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query", e);
        } finally {
            disconnectDB();
        }
        return airports;
    }

    /**
     * Additional method that run lines in Airport table, sets value from it to particular
     * object and after all return it.
     *
     * @param resultSet cursor which points to the current data table row
     * @return object of Airport class
     */
    private Airport parseAirport(ResultSet resultSet) {
        Airport airport = new Airport();
        try {
            airport.setAirportId(resultSet.getInt("AIRPORT_ID"));
            airport.setAirportName(resultSet.getString("AIRPORT_NAME"));
            airport.setAirportLocation(resultSet.getString("LOCATION"));
        } catch (SQLException e) {
            LOGGER.error("Wrong column name", e);
        }
        return airport;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Flight> getFlightInfo() {
        List<Flight> flights = new ArrayList<>();
        connectDB();
        System.out.println("We're rertieve data from DB");
        try {
            ps = connection.prepareStatement(VIEW_FLIGHT_LIST);
            rs = ps.executeQuery();
            Flight flight;
            while (rs.next()) {
                flight = parseFlight(rs);
                flights.add(flight);
                System.out.println("Was added to the list");
            }
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query", e);
        } finally {
            disconnectDB();
        }
        return flights;
    }

    /**
     * Additional method that run lines in Flight table, sets value from it to particular
     * object and after all return it.
     *
     * @param resultSet cursor which points to the current data table row
     * @return object of Flight class
     */
    private Flight parseFlight(ResultSet resultSet) {
        Flight flight = new Flight();
        try {
            flight.setFlightId(resultSet.getInt("FLIGHT_ID"));
            flight.setFlightName(resultSet.getString("FLIGHT_NAME"));
            flight.setFlightTime(resultSet.getString("FLIGHT_TIME"));
            flight.setAirportId(resultSet.getInt("AIRPORT_ID"));
            flight.setPlaneId(resultSet.getInt("PLANE_ID"));
            System.out.println(flight);
        } catch (SQLException e) {
            LOGGER.error("Wrong column name", e);
        }
        return flight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Plane> getPlaneInfo() {
        List<Plane> planes = new ArrayList<>();
        connectDB();
        try {
            ps = connection.prepareStatement(VIEW_PLANE_LIST);
            rs = ps.executeQuery();
            Plane plane;
            while (rs.next()) {
                plane = parsePlane(rs);
                planes.add(plane);
            }
        } catch (SQLException e) {
            LOGGER.error("Invalid sql query", e);
        } finally {
            disconnectDB();
        }
        return planes;
    }

    /**
     * Additional method that run lines in Plane table, sets value from it to particular
     * object and after all return it.
     *
     * @param resultSet cursor which points to the current data table row
     * @return object of Plane class
     */
    private Plane parsePlane(ResultSet resultSet) {
        Plane plane = new Plane();
        try {
            plane.setPlaneId(resultSet.getInt("PLANE_ID"));
            plane.setPlaneName(resultSet.getString("PLANE_NAME"));
            plane.setPlaneType(resultSet.getString("PLANE_TYPE"));
        } catch (SQLException e) {
            LOGGER.error("Wrong column name", e);
        }
        return plane;
    }
}
