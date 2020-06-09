<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Add|Edit Flight Ticket Info</title>
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
    <c:if test="${operation == 'add'}">
        <p>Add new ticket</p>
        <form:form action="${pageContext.request.contextPath}/systems/addFlightTicket" method="post">
        <div class="row">
            <div class="col-25">
                <label for="serialNumber_1">Serial number:</label>
            </div>
            <div class="col-75">
                <input type="text"
                   id="serialNumber_1"
                   name="number"
                   placeholder="CPX0DD75TR"
                   pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{5,10}$"
                   title="The serial number shall have at least 5 symbols"
                   required>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="flightId_1">Flight Id:</label>
            </div>
            <div class="col-75">
                <select id="flightId_1" name="flightId" required >
                <option value="-1">Select the id</option>
                    <c:forEach items="${flights}" var="temp">
                        <option value="${temp.flightId}">
                                ${temp.flightId}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="text_1">Description:</label>
            </div>
            <div class="col-75">
                <textarea id="text_1" name="text"
                      rows = "5" cols = "30"
                      minlength="10" maxlength="100">
                    Describe the ticket here.
                </textarea>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="firstDate_1">Flight Date:</label>
            </div>
            <div class="col-75">
                <input type="datetime-local" id="firstDate_1" name="startDate" required>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="secondDate_1">Arrival Date:</label>
            </div>
            <div class="col-75">
                <input type="datetime-local" id="secondDate_1" name="endDate" required>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="price_1">Price:</label>
            </div>
            <div class="col-75">
                <input type="text"
                   id="price_1"
                   name="price"
                   class="number_input"
                   placeholder="00000000.00"
                   pattern="[0-9]+(\.[0-9]{1,2})?%?"
                   title="This must be a number with up to 2 decimal places"
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
        <p>Edit existed ticket</p>
        <form:form action="${pageContext.request.contextPath}/systems/updateFlightTicket" method="post">
            <input type="hidden" name="ticketId" value="${ticket.ticketId}">
        <div class="row">
            <div class="col-25">
                <label for="serialNumber_2">Serial number:</label>
            </div>
            <div class="col-75">
                <input type="text"
                   id="serialNumber_2"
                   name="number"
                   placeholder="CPX0DD75TR"
                   pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{5,10}$"
                   title="The serial number shall have at least 5 symbols"
                   required>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="flightId_2">Flight Id:</label>
            </div>
            <div class="col-75">
                <select id="flightId_2" name="flightId" required>
                <option value="-1">Select the id</option>
                    <c:forEach items="${flights}" var="value">
                        <option value="${value.flightId}">
                                ${value.flightId}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="text_2">Description:</label>
            </div>
            <div class="col-75">
                <textarea id="text_2" name="text"
                      rows = "5" cols = "30"
                      minlength="10" maxlength="100">
                    Describe the ticket here.
                </textarea>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="firstDate_2">Flight Date:</label>
            </div>
            <div class="col-75">
                <input type="datetime-local" id="firstDate_2" name="startDate" required>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="secondDate_2">Arrival Date:</label>
            </div>
            <div class="col-75">
                <input type="datetime-local" id="secondDate_2" name="endDate" required>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="price_2">Price:</label>
            </div>
            <div class="col-75">
                <input type="text"
                   id="price_2"
                   name="price"
                   class="number_input"
                   placeholder="00000000.00"
                   pattern="[0-9]+(\.[0-9]{1,2})?%?"
                   title="This must be a number with up to 2 decimal places"
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
