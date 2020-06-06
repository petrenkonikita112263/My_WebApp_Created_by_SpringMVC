<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Page For Add|Edit Customer's Info</title>
</head>
    <body>
        <c:if test="${operation == 'add'}">
            <p>Add new customer</p>
            <form:form action="${pageContext.request.contextPath}/systems/addCustomer" method="post">
                Username:
                <input type="text" name="name" placeholder="name">
                Password:
                <input type="text" name="password" required value="{noop}">
                <input type="submit" value="Submit">
            </form:form>
            <br>
            <security:authorize access="hasRole('ADMIN')">
                <p>
                    Return to <a href="${pageContext.request.contextPath}/systems">Admin Page</a>
                    <c:if test="${infoMessage != null}">
                        <c:redirect url="/systems" />
                    </c:if>
                </p>
            </security:authorize>
        </c:if>
        <c:if test="${operation == 'update'}">
            <p>Change existed customer</p>
            <form:form action="${pageContext.request.contextPath}/systems/updateCustomer" method="post">
                <input type="hidden" name="customerId" value="${customer.id}">
                Username:
                <input type="text" name="name" placeholder="name">
                Password:
                <input type="text" name="password" required value="{noop}">
                <input type="submit" value="Submit">
            </form:form>
            <br>
            <security:authorize access="hasRole('ADMIN')">
                <p>
                    Return to <a href="${pageContext.request.contextPath}/systems">Admin Page</a>
                    <c:if test="${infoMessage != null}">
                        <c:redirect url="/systems" />
                    </c:if>
                </p>
            </security:authorize>
        </c:if>
    </body>
</html>
