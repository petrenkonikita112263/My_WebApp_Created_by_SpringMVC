<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Open Public Page</title>
    <spring:url var="css" value="/static/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="${css}">
</head>
    <body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">AIRLINE</a>
                <a href="${pageContext.request.contextPath}/showFlights">Flight Page</a>
                <a href="${pageContext.request.contextPath}/showPlanes">Plane Page</a>
                <a href="${pageContext.request.contextPath}/showAirports">Airport Page</a>
            </div>
        </div>
    </nav>
    <div class="jumbotron">
        <h1 class="display-4">Welcome to Open-Airline!</h1>
        <p class="lead">
            Greetings! This page is open to the <strong>public</strong> view.
            It's not required to log in anyone.
            This web application can do many operations: customers can list own orders, buy the ticket to the flight.
            Admin - can perform system administration: delete|update|add customer, same with ticket.
         </p>
        <hr class="my-4">
        <p class="lead">But for <em>further survey</em> you've to <strong>log in</strong>.</p>
        <sec:authorize access="!isAuthenticated()">
            <p><a class="btn btn-lg btn-success" href="${pageContext.request.contextPath}/guests" role="button">Log In</a></p>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <p>Your login: <sec:authentication property="principal.username" /></p>
            <p><a class="btn btn-lg btn-danger" href="${pageContext.request.contextPath}/logout" role="button">Log out</a></p>
        </sec:authorize>
    </div>
    </body>
</html>
