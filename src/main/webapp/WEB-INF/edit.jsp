<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<style>
    body {text-align: center;}
</style>
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
    <button type="submit">Confirm Change</button>
</form>
</p>
</body>
</html>