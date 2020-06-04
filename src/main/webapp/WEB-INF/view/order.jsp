<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Orders Page</title>
</head>
    <body>
    <div class="container">
        <table class="table">
            <caption>List of cutstomers orders</caption>
            <thead>
            <tr>
                <th scope="col">CUSTOMER_ORDER_ID</th>
                <th scope="col">CUSTOMER_ID</th>
                <th scope="col">ORDER_TIME</th>
                <th scope="col">PRICE</th>
                <th scope="col">DISCOUNT</th>
                <th scope="col">FINAL_PRICE</th>
            </tr>
            </thead>
            <c:forEach items="${customersOrders}" var="temp">
                <tbody>
                <tr>
                    <th scope="row">${temp.customerOrderId}</th>
                    <td>${temp.customerId}</td>
                    <td>${temp.orderTime}</td>
                    <td>${temp.price}</td>
                    <td>${temp.discount}</td>
                    <td>${temp.finalPrice}</td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
        <br>
        <hr>
        <br>
        <table class="table">
            <caption>List of orders</caption>
            <thead>
            <tr>
                <th scope="col">ORDER_ID</th>
                <th scope="col">CUSTOMER_ORDER_ID</th>
                <th scope="col">TICKET_ID</th>
            </tr>
            </thead>
            <c:forEach items="${orderedTickets}" var="temp">
                <tbody>
                <tr>
                    <th scope="row">${temp.orderId}</th>
                    <td>${temp.customerOrderId}</td>
                    <td>${temp.ticketId}</td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
    <hr>
    Back to the customer page <a href="${pageContext.request.contextPath}/customers">page</a>
    </body>
</html>
