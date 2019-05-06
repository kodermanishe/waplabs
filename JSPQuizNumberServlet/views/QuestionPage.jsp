<%-- 
    Document   : QuestionPage
    Created on : May 6, 2019, 12:00:30 PM
    Author     : 987066
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The number , your age is ${age}</title>
        <style><%@include file="style.css"%></style>
    </head>
    <body>
        <div>
            <form method='post'>
            <h2>The number quiz</h2>
            <p>Your current score is ${score}</p>
            <p>Guess the next number in the sequence.</p>
            <p>${question}</p>
            <label>Your answer:</label><input type='text' name='answer' width='3'><br/>
            <input type='submit' value='Submit'>
            </form>
        </div>
    </body>
</html>
