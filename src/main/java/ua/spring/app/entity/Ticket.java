package ua.spring.app.entity;

import java.util.Objects;

public class Ticket {

    private int ticketId;
    private String serialNumber;
    private int flightId;
    private String description;
    private String flightDate;
    private String arrivalDate;
    private double price;

    public Ticket() {
    }

    public Ticket(int ticketId, String serialNumber, int flightId,
                  String description, String flightDate, String arrivalDate, double price) {
        this.ticketId = ticketId;
        this.serialNumber = serialNumber;
        this.flightId = flightId;
        this.description = description;
        this.flightDate = flightDate;
        this.arrivalDate = arrivalDate;
        this.price = price;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticketId=" + ticketId
                + ", serialNumber='" + serialNumber + '\''
                + ", flightId='" + flightId + '\''
                + ", description='" + description + '\''
                + ", flightDate=" + flightDate
                + ", arrivalDate=" + arrivalDate
                + ", price=" + price + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if ((o == null) || (getClass() != o.getClass())) {
            return false;
        } else {
            Ticket ticket = (Ticket) o;
            return ticketId == ticket.ticketId
                    && flightId == ticket.flightId
                    && Double.compare(ticket.price, price) == 0
                    && Objects.equals(serialNumber, ticket.serialNumber)
                    && Objects.equals(description, ticket.description)
                    && Objects.equals(flightDate, ticket.flightDate)
                    && Objects.equals(arrivalDate, ticket.arrivalDate);
        }
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(ticketId, serialNumber, flightId,
                description, flightDate, arrivalDate, price);
        return (27 + result * 3) / 4;
    }
}
