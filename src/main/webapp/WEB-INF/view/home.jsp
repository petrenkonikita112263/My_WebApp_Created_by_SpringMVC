<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home Page</title>
</head>
    <body>
        <p>
            Welcome to the home page of this web app.
        </p>
        <br>
        <hr>
        <p>
            Customer: <security:authentication property="principal.username" />
            <br>
            Role(s): <security:authentication property="principal.authorities" />
        </p>
        <br>
        <hr>
        <security:authorize access="hasRole('CUSTOMER')">
            <p>
                <a href="${pageContext.request.contextPath}/customers">Customer Page</a>
                (Only for customers)
            </p>
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">
            <p>
                <a href="${pageContext.request.contextPath}/systems">Admin Page</a>
                (Only for admins)
            </p>
        </security:authorize>
        <br>
        <form:form action="${pageContext.request.contextPath}/logout" method="post">
            <input type="submit" value="Logout" />
        </form:form>
    </body>
</html>
