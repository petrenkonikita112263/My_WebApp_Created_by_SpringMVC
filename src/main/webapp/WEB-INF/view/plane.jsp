<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Plane Info Table</title>
    <spring:url var="css" value="/static/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="${css}">
</head>
    <body>
    <div class="container">
        <table class="table">
            <caption>List of planes</caption>
            <thead>
            <tr>
                <th scope="col">PLANE_ID</th>
                <th scope="col">PLANE_NAME</th>
                <th scope="col">PLANE_TYPE</th>
            </tr>
            </thead>
            <c:forEach items="${listOfPlane}" var="planes">
                <tbody>
                <tr>
                    <th scope="row">${planes.planeId}</th>
                    <td>${planes.planeName}</td>
                    <td>${planes.planeType}</td>
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
