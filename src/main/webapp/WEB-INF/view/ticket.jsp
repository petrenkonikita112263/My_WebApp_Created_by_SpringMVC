<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Ticket Page</title>
</head>
    <body>
    <div class="container">
        <table class="table">
            <caption>List of tickets</caption>
            <thead>
            <tr>
                <th scope="col">TICKET_ID</th>
                <th scope="col">SERIAL_NUMBER</th>
                <th scope="col">FLIGHT_ID</th>
                <th scope="col">DESCRIPTION</th>
                <th scope="col">FLIGHT_DATE</th>
                <th scope="col">ARRIVAL_DATE</th>
                <th scope="col">PRICE</th>
            </tr>
            </thead>
            <c:forEach items="${listOfTicket}" var="ticket">
                <tbody>
                <tr>
                    <th scope="row">${ticket.ticketId}</th>
                    <td>${ticket.serialNumber}</td>
                    <td>${ticket.flightId}</td>
                    <td>${ticket.description}</td>
                    <td>${ticket.flightDate}</td>
                    <td>${ticket.arrivalDate}</td>
                    <td>${ticket.price}</td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
    <hr>
    Back to the customer page <a href="${pageContext.request.contextPath}/customers">page</a>
    </body>
</html>
