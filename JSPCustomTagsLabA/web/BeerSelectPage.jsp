<%-- 
    Document   : BeerSelectPage
    Created on : May 7, 2019, 12:02:06 PM
    Author     : 987066
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beer advise</title>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    </head>
    <body>
        <h1>Beer Selection Advise</h1>
        <c:forEach var="val" items="${beers}">
            <br/>try: ${val}
        </c:forEach>
    </body>
</html>
