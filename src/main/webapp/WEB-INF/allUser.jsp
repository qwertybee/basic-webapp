<%@ page import="io.muic.ooc.webapp.security.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
    List<User> allUser = (List<User>) request.getAttribute("allUsers");
%>

<html>
<style>
    h1 {text-align: center;}
    h2 {text-align: center}
    form {text-align: center}
    table {text-align: center;}
    div {text-align: center;}
</style>
<head>
    <title>All available users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
    <h1>List of all available users</h1>
    <form action="/logout" method="get">
        <button type="submit" class="btn btn-outline-warning">Log out</button>
    </form>
    <h2>
        Hello ${username}!
    </h2>
    <div class="container">
        <form action="/register" method="get">
            <button type="submit" class="btn btn-outline-success">Add a new user</button>
        </form>
        <p>
            ${deletionDenied}
            ${deletionSucceeded}
            ${accountEditSucceeded}
            ${registrationSucceeded}
            ${notUniqueUsername}
        </p>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Name</th>
                    <th>Edit user</th>
                    <th>Remove user</th>
                </tr>
                </thead>
                <tbody>
                    <% for (User user : allUser) {%>
                        <tr>
                            <td><%=user.getId()%></td>
                            <td><%=user.getUsername()%></td>
                            <td><%=user.getName()%></td>
                            <td>
                                <form action="/edit" method="get">
                                    <button type="submit" class="btn btn-outline-primary" name="editUser" value=<%=user.getUsername()%>>Edit</button>
                                </form>
                            </td>
                            <td>
                                <form action="/" method="post">
                                    <button type="submit" class="btn btn-outline-danger" name="deleteUser" value=<%=user.getUsername()%>
                                            onclick="return confirm('Are you sure you want to remove user: <%=user.getUsername()%>?')">
                                    Remove
                                    </button>
                                </form>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </body>
</html>