<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Ticket Basket Form</title>
    <spring:url var="css" value="/static/css/styleForm.css" />
    <link type="text/css" rel="stylesheet" href="${css}">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.number_input').mask('00000000.00', { reverse: true });
        });
    </script>
</head>
    <body>
    <div class="container">
        <p>Buy flight ticket</p>
        <form:form action="${pageContext.request.contextPath}/customers/buyTicket" method="post">
        <div class="row">
            <div class="col-25">
                <label for="firstPrice">Price:</label>
            </div>
            <div class="col-75">
                <input type="text"
                   id="firstPrice"
                   name="ticketPrice"
                   class="number_input"
                   placeholder="00000000.00"
                   pattern="[0-9]+(\.[0-9]{1,2})?%?"
                   title="This must be a number with up to 2 decimal places"
                   required>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="discount">Discount:</label>
            </div>
            <div class="col-75">
                <input type="text"
                   id="discount"
                   name="discount"
                   class="number_input"
                   placeholder="00000000.00"
                   pattern="[0-9]+(\.[0-9]{1,2})?%?"
                   title="This must be a number with up to 2 decimal places"
                   required>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="lastPrice">Final Price:</label>
            </div>
            <div class="col-75">
                <input type="text"
                   id="lastPrice"
                   name="finalPrice"
                   class="number_input"
                   placeholder="00000000.00"
                   pattern="[0-9]+(\.[0-9]{1,2})?%?"
                   title="This must be a number with up to 2 decimal places"
                   required>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="ticketId">Ticket Id:</label>
            </div>
            <div class="col-75">
                <select id="ticketId" name="id" required>
                <option value="-1">Select the id</option>
                    <c:forEach items="${tickets}" var="var">
                        <option value="${var.ticketId}">
                                ${var.ticketId}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
            <input type="submit" value="Submit">
        </form:form>
        <security:authorize access="hasRole('CUSTOMER')">
            <p>
                Return to <a href="${pageContext.request.contextPath}/customers">Customer Page</a>
                <c:if test="${infoMessage != null}">
                    <c:redirect url="/customers" />
                </c:if>
            </p>
        </security:authorize>
    </div>
    </body>
</html>
