<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Admin Home Page</title>
    <spring:url var="css" value="/static/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="${css}">
</head>
    <body>
        <div class="jumbotron">
            <h1 class="display-4">Admin Home Page</h1>
            <p class="lead">
                Application needs some fix? Update?.
                <strong>Let's do that</strong>
            </p>
            <hr class="my-4">
            <ul class="list-group">
                <li class="list-group-item">
                    <a href="${pageContext.request.contextPath}/systems/showCustomers">Display whole
                        the list of available customers</a>
                </li>
                <li class="list-group-item">
                    <a href="${pageContext.request.contextPath}/systems/showCustomerForm">Create new customer</a>
                </li>
                <li class="list-group-item">
                    <a href="${pageContext.request.contextPath}/showTicket">Display available flight's ticket</a>
                </li>
                <li class="list-group-item">
                    <a href="${pageContext.request.contextPath}/systems/showFlightTicketForm">Add new flight ticket</a>
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
