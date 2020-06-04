package ua.spring.app.entity;

import java.util.Objects;

public class Flight {

    private int flightId;
    private String flightName;
    private String flightTime;
    private int planeId;
    private int airportId;

    public Flight() {
    }

    public Flight(int flightId, String flightName, String flightTime,
                  int planeId, int airportId) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.flightTime = flightTime;
        this.planeId = planeId;
        this.airportId = airportId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    @Override
    public String toString() {
        return "Flight{" + "flightId=" + flightId
                + ", flightName='" + flightName + '\''
                + ", flightTime=" + flightTime
                + ", airportId=" + airportId
                + ", planeId=" + planeId + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if ((o == null) || (getClass() != o.getClass())) {
            return false;
        } else {
            Flight flight = (Flight) o;
            return flightId == flight.flightId
                    && airportId == flight.airportId
                    && planeId == flight.planeId
                    && Objects.equals(flightName, flight.flightName)
                    && Objects.equals(flightTime, flight.flightTime);
        }
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(flightId, flightName, flightTime, airportId, planeId);
        return (27 + result * 3) / 4;
    }
}
