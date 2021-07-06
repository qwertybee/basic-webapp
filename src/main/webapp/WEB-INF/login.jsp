<%@ page contentType="text/html; charset=UTF-8" language="java" %>
    <html>
    <style>
        body {text-align: center;}
    </style>
    <head>
        <title>
            Login Webapp
        </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <h1>
        Log in to basic-webapp
    </h1>
    <body>
    <p>
        ${error}
    </p>
    <p>
    <form action="/login" method="post">
        <input type="text" placeholder="Enter Username" name="username" required>
        <input type="password" placeholder="Enter Password" name="password" required>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
    </p>
    </body>
    </html>