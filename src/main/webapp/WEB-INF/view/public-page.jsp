<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Open Public Page</title>
</head>
    <body>
        <p>
            Greetings! This page is open to the <strong>public</strong> view.
            It's not required to log in anyone.
        </p>
        <br>
        <p>Additional info</p>
        <ul>
            <li><a href="${pageContext.request.contextPath}/showFlights">Flight Page</a></li>
            <li><a href="${pageContext.request.contextPath}/showPlanes">Plane Page</a></li>
            <li><a href="${pageContext.request.contextPath}/showAirports">Airport Page</a></li>
        </ul>
        <hr>
        <p>
            But for <em>further survey</em> you've to <strong>log in</strong>.
            <br>
            <a href="${pageContext.request.contextPath}/guests">Access Secure Site</a>
        </p>
    </body>
</html>
