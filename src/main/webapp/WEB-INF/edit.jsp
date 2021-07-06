<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<style>
    body {text-align: center;}
</style>
<head>
    <title>
        Edit user
    </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<p>
<h2>
    Please enter the account info you wish to change from user: ${editUser}
</h2>
<p>
    ${notUniqueUsername}
</p>
<form action="/edit" method="post">
    <input type="text" placeholder="Enter new username" name="changeUsername" required>
    <input type="text" placeholder="Enter new password" name="changePass" required>
    <input type="text" placeholder="Enter new name" name="changeName" required>
    <button type="submit" class="btn btn-primary">Confirm change</button>
</form>
</p>
</body>
</html>