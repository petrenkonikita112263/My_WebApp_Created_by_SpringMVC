<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Customer Home Page</title>
    <spring:url var="css" value="/static/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="${css}">
</head>
    <body>
        <div class="jumbotron">
            <h1 class="display-4">Customer Home Page</h1>
            <p class="lead">
                Welcome to your customer cart of ordered ticket.
            </p>
            <hr class="my-4">
            <ul class="list-group">
                <li class="list-group-item">
                    <a href="${pageContext.request.contextPath}/showTicket">Display whole
                        the list of available tickets</a>
                </li>
                <li class="list-group-item">
                    <a href="${pageContext.request.contextPath}/customers/showCustomerOrder">Display my own history
                        of orders</a>
                </li>
                <li class="list-group-item">
                    <a href="${pageContext.request.contextPath}/customers/showOrderTicket">Display my own
                        list of ordered tickets</a>
                </li>
                <li class="list-group-item">
                    <a href="${pageContext.request.contextPath}/customers/showTicketBuyForm">Buy the ticket</a>
                </li>
            </ul>
            <hr class="my-4">
            Back to the main
            <button type="button" class="btn btn-secondary">
                <a href="${pageContext.request.contextPath}/guests">page</a>
            </button>
        </div>
    </body>
</html>
