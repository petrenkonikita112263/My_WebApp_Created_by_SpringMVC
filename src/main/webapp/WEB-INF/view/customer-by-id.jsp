<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Customer Info</title>
</head>
    <body>
    <div class="container">
        <c:if test="${not empty msg}">
            <div class="alert alert-${css} alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <strong>${msg}</strong>
            </div>
        </c:if>
        <h2>Customer Detail</h2>
        <br>
        <div class="row">
            <label class="col-sm-2">ID</label>
            <div class="col-sm-10">${customer.id}</div>
        </div>
        <div class="row">
            <label class="col-sm-2">UserName</label>
            <div class="col-sm-10">${customer.userName}</div>
        </div>
        <div class="row">
            <label class="col-sm-2">Password</label>
            <div class="col-sm-10">${customer.password}</div>
        </div>
        <div class="row">
            <label class="col-sm-2">Role</label>
            <div class="col-sm-10">${customer.role}</div>
        </div>
        <div class="row">
            <label class="col-sm-2">Enable</label>
            <div class="col-sm-10">${customer.enable}</div>
        </div>
    </div>
    <hr>
    Back to the admin page <a href="${pageContext.request.contextPath}/systems">page</a>
    </body>
</html>
