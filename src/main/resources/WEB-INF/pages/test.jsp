<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>

    </head>
    <body>

        <form action="/work" method="POST">
            <h1>Wellcome</h1>
            <c:forEach var="t" items="${arr}">
                ${t}<br>
            </c:forEach>
            <input type="text" name="mes">
            <input type="submit" value="ok!">
        </form>
    </body>
</html>