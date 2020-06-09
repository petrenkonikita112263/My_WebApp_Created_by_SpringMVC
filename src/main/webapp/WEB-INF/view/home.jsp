<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Home Page</title>
    <spring:url var="css" value="/static/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="${css}">
</head>
    <body>
        <div class="jumbotron">
            <h1 class="display-4">Welcome <security:authentication property="principal.username" /> to Open-Airline!</h1>
            <p class="lead">
                Greetings! You've the role(s): <security:authentication property="principal.authorities" />
            </p>
            <hr class="my-4">
            <security:authorize access="hasRole('CUSTOMER')">
                <p class="lead">
                    <a href="${pageContext.request.contextPath}/customers">Customer Page</a>
                    (Only for customers)
                </p>
            </security:authorize>
            <security:authorize access="hasRole('ADMIN')">
                <p class="lead">
                    <a href="${pageContext.request.contextPath}/systems">Admin Page</a>
                    (Only for admins)
                </p>
            </security:authorize>
            <br>
            <form:form action="${pageContext.request.contextPath}/logout" method="post">
                <input type="submit" value="Logout" />
            </form:form>
        </div>
    </body>
</html>
