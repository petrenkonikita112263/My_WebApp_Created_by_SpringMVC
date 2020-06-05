package ua.spring.app.service;

public interface Orderable {

    void addFlightTicket(String number, int flightId, String text, String startDate,
                         String endDate, double price);

    void removeFlightTicket(int id);

    void editFlightTicket(Integer id, String number, int flightId, String text, String startDate,
                          String endDate, double price);

}
