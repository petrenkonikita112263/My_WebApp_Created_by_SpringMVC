<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Ticket Basket Form</title>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.number_input').mask('00000000.00', { reverse: true });
        });
    </script>
</head>
    <body>
        <p>Buy flight ticket</p>
        <form:form action="${pageContext.request.contextPath}/customers/buyTicket" method="post">
            <label for="firstPrice">Price:</label>
            <input type="text"
                   id="firstPrice"
                   name="ticketPrice"
                   class="number_input"
                   placeholder="00000000.00"
                   pattern="[0-9]+(\.[0-9]{1,2})?%?"
                   title="This must be a number with up to 2 decimal places"
                   required>
            <br>
            <label for="discount">Discount:</label>
            <input type="text"
                   id="discount"
                   name="discount"
                   class="number_input"
                   placeholder="00000000.00"
                   pattern="[0-9]+(\.[0-9]{1,2})?%?"
                   title="This must be a number with up to 2 decimal places"
                   required>
            <br>
            <label for="lastPrice">Final Price:</label>
            <input type="text"
                   id="lastPrice"
                   name="finalPrice"
                   class="number_input"
                   placeholder="00000000.00"
                   pattern="[0-9]+(\.[0-9]{1,2})?%?"
                   title="This must be a number with up to 2 decimal places"
                   required>
            <br>
            <label for="ticketId">Ticket Id:</label>
            <select id="ticketId" name="id" required>
                <option value="-1">Select the id</option>
                <c:forEach items="${tickets}" var="var">
                    <option value="${var.ticketId}">
                            ${var.ticketId}
                    </option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Submit">
        </form:form>
    </body>
</html>
