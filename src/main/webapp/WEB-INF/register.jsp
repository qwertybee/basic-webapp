<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<style>
    body {text-align: center;}
</style>
<head>
    <title>
        Register new user
    </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<p>
    ${notUniqueUsername}
</p>
<p>
<h2>
    Create new account.
</h2>
<form action="/register" method="post">
    <input type="text" placeholder="Enter new username" name="newUsername" required>
    <input type="text" placeholder="Enter new password" name="newPass" required>
    <input type="text" placeholder="Enter new name" name="newName" required>
    <button type="submit" class="btn btn-primary">Create new account</button>
</form>
</p>
</body>
</html>