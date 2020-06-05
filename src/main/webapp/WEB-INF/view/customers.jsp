<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Home Page</title>
</head>
    <body>
        <h2>
            Customer Home Page
        </h2>
    <br>
    <hr>
        <p>
            Welcome to your customer cart of ordered ticket.
        </p>
        <p>
            <ul>
                <li><a href="${pageContext.request.contextPath}/showTicket">Display whole
                    the list of available tickets</a></li>
                <li><a href="${pageContext.request.contextPath}/customers/showCustomerOrder">Display whole
                    the list of customer's orders</a></li>
                <li><a href="${pageContext.request.contextPath}/customers/showOrderTicket">Display whole
                    the list of ordered tickets</a></li>
            </ul>
        </p>
    <hr>
    Back to the main <a href="${pageContext.request.contextPath}/guests">page</a>
    </body>
</html>
