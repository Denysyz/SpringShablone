<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>My Page</title>
    </head>
    <body>
        <h1>
            Registration
        </h1>
        <form action="/registration2" method="POST">
            Login: <input type="text" name="login"><br>
            Password: <input type="password" name="password"><br>
            Name: <input type="text" name="name"><br>
            Surname: <input type="text" name="surname"><br>
            Age: <input type="text" name="age"><br>
            Country: <input type="text" name="country"><br>
            <input type="submit" value="Registration">
        </form>
    </body>
</html>