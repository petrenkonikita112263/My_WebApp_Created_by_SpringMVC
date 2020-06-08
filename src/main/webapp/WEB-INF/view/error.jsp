<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Error 404</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
    <div class="d-flex justify-content-center align-items-center" id="main">
        <h1 class="mr-3 pr-3 align-top border-right inline-block align-content-center">404</h1>
        <div class="inline-block align-middle">
            <h2 class="font-weight-normal lead" id="desc">The page you requested was not found.
                <p>Your request parameter is: ${msg}</p>
            </h2>
        </div>
    </div>
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
