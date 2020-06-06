<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Flight Ticket Info</title>
</head>
    <body>
    <c:if test="${operation == 'add'}">
        <p>Add new ticket</p>
        <form:form action="${pageContext.request.contextPath}/systems/addFlightTicket" method="post">
            Serial number:
            <input type="text" name="number" placeholder="CPX0DD75TR" required>
            <br>
            Flight Id:
            <select required name="flightId">
                <option value="-1">Select the id</option>
                <c:forEach items="${flights}" var="temp">
                    <option value="${temp.flightId}">
                            ${temp.flightId}
                    </option>
                </c:forEach>
            </select>
            <br>
            Description for ticket
            <textarea name="text" rows = "5" cols = "30"></textarea>
            <br>
            Flight Date:
            <input type="datetime-local" name="startDate" required>
            <br>
            Arrival Date:
            <input type="datetime-local" name="endDate" required>
            <br>
            Price:
            <input type="number" name="price" required>
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
            Serial number:
            <input type="text" name="number" placeholder="CPX0DD75TR" required>
            <br>
            Flight Id:
            <select required name="flightId">
                <option value="-1">Select the id</option>
                <c:forEach items="${flights}" var="value">
                    <option value="${value.flightId}">
                            ${value.flightId}
                    </option>
                </c:forEach>
            </select>
            <br>
            Description for ticket
            <textarea name="text" rows = "5" cols = "30"></textarea>
            <br>
            Flight Date:
            <input type="datetime-local" name="startDate" required>
            <br>
            Arrival Date:
            <input type="datetime-local" name="endDate" required>
            <br>
            Price:
            <input type="number" name="price" required>
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
