<%-- 
    Document   : ResaltPage
    Created on : May 6, 2019, 12:00:54 PM
    Author     : 987066
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result, your age is <span>${age}</span></title>
        <style><%@include file="style.css"%></style>
    </head>
    <body>       
        <h2>Your current grade is <span>${grade}</span></h2>
         <p>You have completed the number quiz, with a score of ${score} out of ${questions}.</p>
    </body>
</html>
