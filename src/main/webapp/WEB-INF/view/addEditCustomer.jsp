<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Page For Add|Edit Customer's Info</title>
    <spring:url var="css" value="/static/css/styleForm.css" />
    <link type="text/css" rel="stylesheet" href="${css}">
</head>
    <body>
    <div class="container">
        <c:if test="${operation == 'add'}">
            <p>Add new customer</p>
            <form:form action="${pageContext.request.contextPath}/systems/addCustomer" method="post">
            <div class="row">
                <div class="col-25">
                    <label for="username_1">Username:</label>
                </div>
                <div class="col-75">
                    <input type="text"
                       id="username_1"
                       name="name"
                       placeholder="Enter the username"
                       pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,50}$"
                       title="The username must be wtih 2-50 chars"
                       required>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="userpassword_1">Password:</label>
                </div>
                <div class="col-75">
                    <input type="text"
                       id="userpassword_1"
                       name="password"
                       placeholder="Enter the password"
                       pattern="^{noop}"
                       title="The password should start with this text {noop} and after that type your password"
                       value="{noop}"
                       required>
                </div>
            </div>
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
            <div class="row">
                <div class="col-25">
                    <label for="username_2">Username:</label>
                </div>
                <div class="col-75">
                    <input type="text"
                       id="username_2"
                       name="name"
                       placeholder="Enter the username"
                       pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,50}$"
                       title="The username must be wtih 2-50 chars"
                       required>
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label for="userpassword_2">Password:</label>
                </div>
                <div class="col-75">
                    <input type="text"
                       id="userpassword_2"
                       name="password"
                       placeholder="Enter the password"
                       pattern="(?!({noop}|{bcrypt})$)\S+"
                       title="The password should start with this text {noop} and after that type your password"
                       value="{noop}"
                       required>
                </div>
            </div>
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
    </div>
    </body>
</html>
