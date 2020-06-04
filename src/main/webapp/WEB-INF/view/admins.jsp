<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Home Page</title>
</head>
    <body>
        <h2>
            Admin Home Page
        </h2>
        <br>
        <hr>
        <p>
            Application needs some fix? Update?.
            <strong>Let's do that</strong>
        </p>
        <p>
            <ul>
                <li><a href="${pageContext.request.contextPath}/systems/showCustomers">Display whole
                    the list of available customers</a></li>
                <li><a href="${pageContext.request.contextPath}/systems/showCustomerForm">Create new customer</a></li>
            </ul>
        </p>
        <hr>
        Back to the main <a href="${pageContext.request.contextPath}/guests">page</a>
    </body>
</html>
