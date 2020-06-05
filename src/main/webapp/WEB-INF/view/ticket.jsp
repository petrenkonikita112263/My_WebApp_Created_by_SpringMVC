<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Ticket Page</title>
</head>
    <body>
    <div class="container">
        <security:authorize access="hasRole('CUSTOMER')">
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
        </security:authorize>>
        <security:authorize access="hasRole('ADMIN')">
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
                <th scope="col">ACTION</th>
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
                    <td>
                        <a href="${pageContext.request.contextPath}/systems/removeFlightTicket/${ticket.ticketId}">
                            DELETE
                        </a>
                        <p>|</p>
                        <a href="${pageContext.request.contextPath}/systems/showFlightTicketEditForm/${ticket.ticketId}">
                            CHANGE
                        </a>
                    </td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
        </security:authorize>
    </div>
    <hr>
    <security:authorize access="hasRole('CUSTOMER')">
        <p>
            Back to the customer page <a href="${pageContext.request.contextPath}/customers">page</a>
        </p>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')">
        <p>
            Back to the admin page <a href="${pageContext.request.contextPath}/systems">page</a>
        </p>
    </security:authorize>
    </body>
</html>
