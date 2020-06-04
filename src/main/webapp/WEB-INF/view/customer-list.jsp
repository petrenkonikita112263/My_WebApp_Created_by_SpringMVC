<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Customer's List</title>
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
    </div>
    <hr>
    Back to the admin page <a href="${pageContext.request.contextPath}/systems">page</a>
    </body>
</html>
