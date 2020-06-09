<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Customer's List</title>
    <spring:url var="css" value="/static/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="${css}">
</head>
    <body>
    <div class="container">
        <table class="table">
            <caption>List of customers</caption>
            <thead>
            <tr>
                <th scope="col">CUSTOMER_ID</th>
                <th scope="col">USERNAME</th>
                <th scope="col">PASSWORD</th>
                <th scope="col">AUTHORITY</th>
                <th scope="col">ENABLED</th>
                <th scope="col">ACTION</th>
            </tr>
            </thead>
            <c:forEach items="${customers}" var="temp">
                <tbody>
                <tr>
                    <th scope="row">${temp.id}</th>
                    <td>${temp.userName}</td>
                    <td>${temp.password}</td>
                    <td>${temp.role}</td>
                    <td>${temp.enable}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/systems/removeCustomer/${temp.id}">
                            DELETE
                        </a>
                        <p>|</p>
                        <a href="${pageContext.request.contextPath}/systems/showCustomerEditForm/${temp.id}">
                            CHANGE
                        </a>
                    </td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    <hr class="my-4">
    Back to the admin
    <button type="button" class="btn btn-secondary">
        <a href="${pageContext.request.contextPath}/systems">page</a>
    </button>
    </div>
    </body>
</html>
