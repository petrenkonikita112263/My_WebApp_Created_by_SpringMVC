<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add|Edit Flight Ticket Info</title>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.number_input').mask('00000000.00', { reverse: true });
        });
    </script>
</head>
    <body>
    <c:if test="${operation == 'add'}">
        <p>Add new ticket</p>
        <form:form action="${pageContext.request.contextPath}/systems/addFlightTicket" method="post">
            <label for="serialNumber">Serial number:</label>
            <input type="text"
                   id="serialNumber"
                   name="number"
                   placeholder="CPX0DD75TR"
                   pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{5,10}$"
                   title="The serial number shall have at least 5 symbols"
                   required>
            <br>
            <label for="flightId">Flight Id:</label>
            <select id="flightId" name="flightId" required >
                <option value="-1">Select the id</option>
                <c:forEach items="${flights}" var="temp">
                    <option value="${temp.flightId}">
                            ${temp.flightId}
                    </option>
                </c:forEach>
            </select>
            <br>
            <textarea name="text"
                      rows = "5" cols = "30"
                      minlength="10" maxlength="100">
                Describe the ticket here.
            </textarea>
            <br>
            <label for="firstDate">Flight Date:</label>
            <input type="datetime-local" id="firstDate" name="startDate" required>
            <br>
            <label for="secondDate">Arrival Date:</label>
            <input type="datetime-local" id="secondDate" name="endDate" required>
            <br>
            <label for="price">Price:</label>
            <input type="text"
                   id="price"
                   name="price"
                   class="number_input"
                   placeholder="00000000.00"
                   pattern="[0-9]+(\.[0-9]{1,2})?%?"
                   title="This must be a number with up to 2 decimal places"
                   required>
            <br>
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
        <p>Edit existed ticket</p>
        <form:form action="${pageContext.request.contextPath}/systems/updateFlightTicket" method="post">
            <input type="hidden" name="ticketId" value="${ticket.ticketId}">
            <label for="serialNumber">Serial number:</label>
            <input type="text"
                   id="serialNumber"
                   name="number"
                   placeholder="CPX0DD75TR"
                   pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{5,10}$"
                   title="The serial number shall have at least 5 symbols"
                   required>
            <br>
            <label for="flightId">Flight Id:</label>
            <select id="flightId" name="flightId" required >
                <option value="-1">Select the id</option>
                <c:forEach items="${flights}" var="value">
                    <option value="${value.flightId}">
                            ${value.flightId}
                    </option>
                </c:forEach>
            </select>
            <br>
            <textarea name="text"
                      rows = "5" cols = "30"
                      minlength="10" maxlength="100">
                Describe the ticket here.
            </textarea>
            <br>
            <label for="firstDate">Flight Date:</label>
            <input type="datetime-local" id="firstDate" name="startDate" required>
            <br>
            <label for="secondDate">Arrival Date:</label>
            <input type="datetime-local" id="secondDate" name="endDate" required>
            <br>
            <label for="price">Price:</label>
            <input type="text"
                   id="price"
                   name="price"
                   class="number_input"
                   placeholder="00000000.00"
                   pattern="[0-9]+(\.[0-9]{1,2})?%?"
                   title="This must be a number with up to 2 decimal places"
                   required>
            <br>
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
