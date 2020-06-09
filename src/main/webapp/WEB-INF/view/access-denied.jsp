<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Permission Error</title>
</head>
    <body>
        <h2>Sorry, you do not have permission to view this page.</h2>
        <hr>
        <security:authorize access="hasRole('GUEST')">
            Click <a href="${pageContext.request.contextPath}/guests">here</a> to go back to the home page.
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">
            Click <a href="<c:url value='/systems' />">here</a> to go back to the home page.
        </security:authorize>
        <security:authorize access="hasRole('CUSTOMER')">
            Click <a href="<c:url value='/customers' />">here</a> to go back to the home page.
        </security:authorize>
    </body>
</html>
