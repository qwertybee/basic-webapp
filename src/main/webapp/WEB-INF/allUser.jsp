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
    table, th, td {
        border: 1px solid black;
    }
</style>

<title>All available users</title>
    <body>
    <h1>List of all available users</h1>
    <form action="/logout" method="get">
        <button type="submit">Log out</button>
    </form>
    <h2>
        Hello ${username}!
    </h2>
    <p>
        ${deletionDenied}
        ${deletionSucceeded}
        ${accountEditSucceeded}
        ${registrationSucceeded}
    </p>
    <form action="/register" method="get">
        <button type="submit">Add a new user</button>
    </form>
    <table>				<!-- create an table object -->
        <tr>				<!-- "tr" represents a row -->
            <th>ID</th>	<!-- use "th" to indicate header row -->
            <th>Username</th>
            <th>Name</th>
            <th>Edit user</th>
            <th>Remove user</th>
        </tr>
        <% for (User user : allUser) {%>
        <tr>                <!-- once again use tr for another row -->
            <td><%=user.getId()%></td>    <!-- use "td" henceforth for normal rows -->
            <td><%=user.getUsername()%></td>
            <td><%=user.getName()%></td>
            <td>
                <form action="/edit" method="get">
                    <button type="submit" name="editUser" value=<%=user.getUsername()%>>edit</button>
                </form>
            </td>
            <td>
                <form action="/" method="post">
                    <button type="submit" name="deleteUser" value=<%=user.getUsername()%>
                            onclick="return confirm('Are you sure you want to remove user: <%=user.getUsername()%>?')">
                        remove
                    </button>
                </form>
            </td>
        </tr>
        <% } %>
    </table>
    </body>
</html>