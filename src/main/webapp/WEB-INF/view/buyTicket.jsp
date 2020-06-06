<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Ticket Basket Form</title>
</head>
    <body>
        <p>Buy flight ticket</p>
        <form:form action="${pageContext.request.contextPath}/customers/buyTicket" method="post">
<%--            <input type="hidden" name="customerName" value=<c:out value="${username}"/> >--%>
<%--            <br>--%>
            Price:
            <input type="text" name="ticketPrice" placeholder="0000.00" required>
            <br>
            Discount:
            <input type="text" name="discount" placeholder="0000.00" required>
            <br>
            Final Price:
            <input type="text" name="finalPrice" placeholder="0000.00" required>
            <br>
            <input type="submit" value="Submit">
        </form:form>
    </body>
</html>
