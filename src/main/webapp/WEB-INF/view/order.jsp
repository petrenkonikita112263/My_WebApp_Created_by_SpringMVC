<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Orders Page</title>
</head>
    <body>
    <div class="container">
        <c:if test="${history == 'customerOrder'}">
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
        </c:if>
        <br>
        <hr>
        <br>
        <c:if test="${history == 'customerOrderTicket'}">
        <table class="table">
            <caption>List of orders</caption>
            <thead>
            <tr>
                <th scope="col">ORDER_ID</th>
                <th scope="col">CUSTOMER_ORDER_ID</th>
                <th scope="col">TICKET_ID</th>
            </tr>
            </thead>
            <c:forEach items="${orderedTickets}" var="var">
                <tbody>
                <tr>
                    <th scope="row">${var.orderId}</th>
                    <td>${var.customerOrderId}</td>
                    <td>${var.ticketId}</td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
        </c:if>
    </div>
    <hr>
    Back to the customer page <a href="${pageContext.request.contextPath}/customers">page</a>
    </body>
</html>
