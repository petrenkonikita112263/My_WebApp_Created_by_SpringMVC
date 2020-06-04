package ua.spring.app.entity;

import java.util.Objects;

public class Airport {

    private int airportId;
    private String airportName;
    private String airportLocation;

    public Airport() {
    }

    public Airport(int airportId, String airportName, String airportLocation) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.airportLocation = airportLocation;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airportId=" + airportId +
                ", airportName='" + airportName + '\'' +
                ", airportLocation='" + airportLocation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if ((o == null) || (getClass() != o.getClass())) {
            return false;
        } else {
            Airport airport = (Airport) o;
            return airportId == airport.airportId
                    && Objects.equals(airportName, airport.airportName)
                    && Objects.equals(airportLocation, airport.airportLocation);
        }
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(airportId, airportName, airportLocation);
        return (27 + result * 3) / 4;
    }
}
