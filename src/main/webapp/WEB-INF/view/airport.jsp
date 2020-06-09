<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
<head>
    <title>Airport Info Table</title>
    <spring:url var="css" value="/static/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="${css}">
</head>
    <body>
    <div class="container">
        <table class="table">
            <caption>List of aiports</caption>
            <thead>
            <tr>
                <th scope="col">AIRPORT_ID</th>
                <th scope="col">AIRPORT_NAME</th>
                <th scope="col">LOCATION</th>
            </tr>
            </thead>
            <c:forEach items="${listOfAirport}" var="airports">
                <tbody>
                <tr>
                    <th scope="row">${airports.airportId}</th>
                    <td>${airports.airportName}</td>
                    <td>${airports.airportLocation}</td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    <hr class="my-4">
    Back to the welcome
    <button type="button" class="btn btn-secondary">
        <a href="${pageContext.request.contextPath}/">page</a>
    </button>
    </div>
    </body>
</html>
