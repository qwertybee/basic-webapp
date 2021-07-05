<%@ page contentType="text/html; charset=UTF-8" language="java" %>
    <html>
    <style>
        body {text-align: center;}
    </style>
    <body>
    <p>
        ${error}
    </p>
    <p>
    <form action="/login" method="post">
        <input type="text" placeholder="Enter Username" name="username" required>
        <input type="password" placeholder="Enter Password" name="password" required>
        <button type="submit">Login</button>
    </form>
    </p>
    </body>
    </html>