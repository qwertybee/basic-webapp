<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<style>
    body {text-align: center;}
</style>
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
    <button type="submit">Create new account</button>
</form>
</p>
</body>
</html>